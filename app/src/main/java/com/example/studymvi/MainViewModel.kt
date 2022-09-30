package com.example.studymvi

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import kotlinx.coroutines.Dispatchers
import java.util.Random


class MainViewModel : ViewModel() {

    var state by mutableStateOf(MainViewState())
        private set


    private val text = MutableLiveData<String>()

    val result1 = text.switchMap {
        liveData(Dispatchers.IO) {
            emit(emit1(it))
//            emitSource()
        }
    }

    val result2 = text.switchMap {
        liveData(Dispatchers.IO) {
            emit(emit2(it))
//            emitSource()
        }
    }

    fun clickButton() {
        val num = Random().nextInt(100)
        text.value = num.toString()
    }

    private fun emit1(item: String) {
        Log.d("결과1", item)
    }

    private fun emit2(item: String) {
        Log.d("결과2", item)
    }

}
