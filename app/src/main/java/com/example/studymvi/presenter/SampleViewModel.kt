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


    private val _listState = mutableStateOf(emptyList<String>())
    val listState: State<List<String>> = _listState

    init {
        _listState.value = IntRange(1, 100).map { "$it" }
    }

    fun onInputChange(input: String) {
        _inputState.value = input
    }

    fun removeItem(item: String) {
        _listState.value = _listState.value.filter { it != item }
    }
}
