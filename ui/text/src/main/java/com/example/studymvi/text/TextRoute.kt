package com.example.studymvi.text

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.studymvi.navigation.Screen

fun NavGraphBuilder.text() {
    composable(route = Screen.Text.route) {
        SampleScreen()
    }
}