package com.example.studymvi.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable

abstract class BaseActivity : ComponentActivity() {

    @Composable
    abstract fun SetContent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetContent()
        }
    }

}