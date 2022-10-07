package com.example.studymvi.presenter

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor() : ViewModel() {

    private val _inputState = mutableStateOf("")
    val inputState: State<String> = _inputState

    fun onInputChange(input: String) {
        _inputState.value = input
    }

}
