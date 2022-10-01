package com.example.studymvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed


class MainViewModel(private val sampleRepository: SampleRepository) : ViewModel() {


    private val getData: Flow<String> = sampleRepository.getData()

    //버튼을 누루지 않고 처음 시작할때 1초뒤에 결과값 얻는 방법.
    val result = getData.transformLatest {
        delay(1000L)
        emit(UiState.GetString(it))
    }.stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(5000),
        initialValue = UiState.Loading
    )
}

sealed class UiState {
    data class GetString(val data: String) : UiState()
    object Loading : UiState()
}

