package com.example.feature_text

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_data.repo.TextRepository
import com.example.core_database.room.entity.TextEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class TextListViewModel @Inject constructor(
    private val textRepository: TextRepository
) :
    ViewModel(), TextListContract {

    private val textsStream: Flow<List<TextEntity>> =
        textRepository.textEntityList

    private val totalTextCountStream: Flow<Int> =
        textRepository.totalTextCount

    private val testTextPreferences: Flow<String> =
        textRepository.testTextPreferences


    private val mutableState = combine(
        textsStream,
        totalTextCountStream,
        testTextPreferences
    ) { texts, totalTextCount, testTextPreferences ->
        TextListContract.State(
            textList = texts,
            totalTextCount = totalTextCount,
            preferenceText = testTextPreferences
        )
    }
    override val state: StateFlow<TextListContract.State> = mutableState.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000L),
        TextListContract.State()
    )

    override fun event(event: TextListContract.Event) {
        when (event) {
            is TextListContract.Event.InsertTextItem -> insertTextItem(event.text)
            is TextListContract.Event.DeleteTextEntity -> removeTextItem(event.textEntity)
        }
    }


    private fun insertTextItem(text: String) {
        if (text.isNotEmpty()) {
            viewModelScope.launch(Dispatchers.IO) {
                val textItem =
                    TextEntity(text = text, date = Calendar.getInstance().timeInMillis)

                if (textRepository.insertTextItem(textItem)) {

                } else {

                }
            }

            updateTestPreferences(text)
        }
    }

    private fun updateTestPreferences(text: String) {
        viewModelScope.launch(Dispatchers.IO) {
            textRepository.updateTestString(text)
        }
    }

    private fun removeTextItem(item: TextEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            if (textRepository.deleteTextItem(item)) {

            } else {

            }
        }
    }
}
