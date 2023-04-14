package com.example.studymvi

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.studymvi.base.BaseActivity
import com.example.studymvi.designsystem.theme.SampleTheme
import com.example.studymvi.navigation.Screen
import com.example.studymvi.text.text
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SampleActivity : BaseActivity() {

    @Composable
    override fun SetContent() {

        SampleTheme() {
            val navHostController = rememberNavController()

            NavHost(navController = navHostController, startDestination = Screen.Text.route) {
                text()
            }
        }
    }
}

