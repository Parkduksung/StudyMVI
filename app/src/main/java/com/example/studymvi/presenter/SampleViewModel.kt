package com.example.studymvi.presenter

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studymvi.data.model.TextItem
import com.example.studymvi.data.repo.TextRepository
import com.example.studymvi.room.entity.TextEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor(private val textRepository: TextRepository) :
    ViewModel() {

    private val _inputState = mutableStateOf("")
    val inputState: State<String> = _inputState

    val texts = textRepository.getTextEntityList().asResult()

    fun onInputChange(input: String) {
        _inputState.value = input
    }

    fun insertTextItem() {
        if (_inputState.value.isNotEmpty()) {
            viewModelScope.launch(Dispatchers.IO) {
                val textItem = TextItem(text = _inputState.value).toTextEntity()

                if (textRepository.insertTextItem(textItem)) {

                } else {

                }
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

sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Error(val exception: Throwable? = null) : Result<Nothing>
    object Loading : Result<Nothing>
}

fun <T> Flow<T>.asResult(): Flow<Result<T>> {
    return this
        .map<T, Result<T>> {
            Result.Success(it)
        }
        .onStart { emit(Result.Loading) }
        .catch { emit(Result.Error(it)) }
}
