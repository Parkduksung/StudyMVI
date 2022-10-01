package com.example.studymvi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collectLatest

class MainActivity : ComponentActivity() {

    private val mainViewModel by lazy {
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                    MainViewModel(InjectRepository.provideSample()) as T
                } else throw IllegalArgumentException()
            }
        })[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenCreated {
            mainViewModel.result.collectLatest { uiState ->
                when (uiState) {
                    is UiState.Loading -> {
                        Log.d("결과", "Loading")
                    }
                    is UiState.GetString -> {
                        Log.d("결과", uiState.data)
                    }
                }
            }
        }

        setContent {
            Button(
                onClick = {

                }) {
            }
        }
    }
}
