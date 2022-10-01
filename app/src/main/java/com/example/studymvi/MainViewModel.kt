package com.example.studymvi

import androidx.lifecycle.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*


class MainViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState : StateFlow<UiState> = _uiState

    fun clickButton() {
        viewModelScope.launch {
            _uiState.value =UiState.GetString(data = Random().nextInt(100).toString())
        }
    }
}

sealed class UiState {
    data class GetString(val data : String) : UiState()
    object Loading : UiState()
}

