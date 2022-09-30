package com.example.studymvi

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.util.*


class MainViewModel : ViewModel() {

    var state by mutableStateOf(MainViewState())
        private set

    private val _uiStateMediator = MutableLiveData<UiState>()
    val uiStateMediator = _uiStateMediator.switchMap { state ->
        liveData {
            when (state) {
                is UiState.SubUiState1 -> emit(emit1(state))
                is UiState.SubUiState2 -> emit(emit2(state))
            }
        }
    }

    fun clickButton() {
        viewModelScope.launch {
            _uiStateMediator.value = UiState.SubUiState1(Random().nextInt(100).toString())
            _uiStateMediator.value = UiState.SubUiState2(Random().nextInt(100).toString())
        }
    }

    private fun emit1(item: UiState.SubUiState1) {
        Log.d("결과1", item.data)
    }

    private fun emit2(item: UiState.SubUiState2) {
        Log.d("결과2", item.data)
    }

}

sealed class UiState {
    data class SubUiState1(val data: String) : UiState()
    data class SubUiState2(val data: String) : UiState()
}
