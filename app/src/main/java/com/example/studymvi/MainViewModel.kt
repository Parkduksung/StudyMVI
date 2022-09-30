package com.example.studymvi

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.util.*


class MainViewModel : ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    private val _uiStateMediator = MutableLiveData<UiState>()
    val uiStateMediator = _uiStateMediator.switchMap { state ->
        liveData {
            state.subUiState1?.let { emit(emit1(it)) }
            state.subUiState2?.let { emit(emit2(it)) }
        }
    }

    fun clickButton() {
        viewModelScope.launch {
            _uiStateMediator.value =
                UiState(subUiState1 = SubUiState1.Sub1(Random().nextInt(100).toString()))
            _uiStateMediator.value =
                UiState(subUiState2 = SubUiState2.Sub2(Random().nextInt(100).toString()))
        }
    }

    private fun emit1(item: SubUiState1) {
        Log.d("결과1", (item as SubUiState1.Sub1).data)
    }

    private fun emit2(item: SubUiState2?) {
        Log.d("결과1", (item as SubUiState2.Sub2).data)
    }

}



data class UiState(
    var commonState: CommonState? = null,
    var subUiState1: SubUiState1? = null,
    var subUiState2: SubUiState2? = null
)

sealed class CommonState {
    data class LoadingState(val isShow: Boolean)
}

sealed class SubUiState1 {
    data class Sub1(val data: String) : SubUiState1()
}

sealed class SubUiState2 {
    data class Sub2(val data: String) : SubUiState2()
}

