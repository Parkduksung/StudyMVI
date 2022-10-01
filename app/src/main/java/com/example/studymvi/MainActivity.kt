package com.example.studymvi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Button
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collectLatest

class MainActivity : ComponentActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        lifecycleScope.launchWhenCreated {
            mainViewModel.uiState.collectLatest { uiState ->
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
                    mainViewModel.clickButton()
                }) {
            }
        }
    }
}
