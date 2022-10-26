package com.example.feature_text

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_common.asResult
import com.example.core_data.repo.TextRepository
import com.example.core_database.room.entity.TextEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import com.example.core_common.Result

@HiltViewModel
class TextListViewModel @Inject constructor(private val textRepository: TextRepository) :
    ViewModel() {

    private val _inputState = mutableStateOf("")
    val inputState: State<String> = _inputState

    private val textsStream: Flow<Result<List<TextEntity>>> =
        textRepository.textEntityList.asResult()

    private val totalTextCountStream: Flow<Result<Int>> =
        textRepository.totalTextCount.asResult()

    private val testTextPreferences: Flow<Result<String>> =
        textRepository.testTextPreferences.asResult()


    val uiState: StateFlow<TextListScreenUiState> =
        combine(
            textsStream,
            totalTextCountStream,
            testTextPreferences
        ) { textsResult, totalCountResult, testTextPreferencesResult ->
            val texts: TextUiState =
                if (textsResult is Result.Success && totalCountResult is Result.Success) {
                    TextUiState.Success(textsResult.data)
                } else if (textsResult is Result.Loading || totalCountResult is Result.Loading) {
                    TextUiState.Loading
                } else {
                    TextUiState.Error
                }

            val totalCount: TotalTextCountUiState =
                when (totalCountResult) {
                    is Result.Success -> TotalTextCountUiState.Success(totalCountResult.data)
                    is Result.Loading -> TotalTextCountUiState.Loading
                    is Result.Error -> TotalTextCountUiState.Error
                }

            val testTextPreferences: TestPreferenceUiState =
                when (testTextPreferencesResult) {
                    is Result.Success -> TestPreferenceUiState.Success(testTextPreferencesResult.data)
                    is Result.Loading -> TestPreferenceUiState.Loading
                    is Result.Error -> TestPreferenceUiState.Error
                }

            TextListScreenUiState(texts, totalCount, testTextPreferences)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = TextListScreenUiState(
                TextUiState.Loading,
                TotalTextCountUiState.Loading,
                TestPreferenceUiState.Loading
            )
        )


    fun onInputChange(input: String) {
        _inputState.value = input
    }

    fun insertTextItem() {
        if (_inputState.value.isNotEmpty()) {
            viewModelScope.launch(Dispatchers.IO) {
                val textItem =
                    TextEntity(text = _inputState.value, date = Calendar.getInstance().timeInMillis)

                if (textRepository.insertTextItem(textItem)) {

                } else {

                }
            }
        }
    }

    fun updateTestPreferences() {
        if (_inputState.value.isNotEmpty()) {
            viewModelScope.launch(Dispatchers.IO) {
                textRepository.updateTestString(_inputState.value)
            }
        }
    }

    fun removeTextItem(item: TextEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            if (textRepository.deleteTextItem(item)) {

            } else {

            }
        }
    }
}

sealed interface TextUiState {
    data class Success(val texts: List<TextEntity>) : TextUiState
    object Error : TextUiState
    object Loading : TextUiState
}

sealed interface TotalTextCountUiState {
    data class Success(val totalCount: Int) : TotalTextCountUiState
    object Error : TotalTextCountUiState
    object Loading : TotalTextCountUiState
}

sealed interface TestPreferenceUiState {
    data class Success(val text: String) : TestPreferenceUiState
    object Error : TestPreferenceUiState
    object Loading : TestPreferenceUiState
}


data class TextListScreenUiState(
    val textUiState: TextUiState,
    val totalTextCountUiState: TotalTextCountUiState,
    val TestPreferenceUiState: TestPreferenceUiState
)