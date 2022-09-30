package com.example.studymvi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Button

class MainActivity : ComponentActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            mainViewModel.result1.observe(this){

            }

            mainViewModel.result2.observe(this){

            }
            Button(
                onClick = {
                    mainViewModel.clickButton()
                }) {
            }
        }
    }
}
