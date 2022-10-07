package com.example.studymvi.presenter

sealed class Screen(val route: String) {
    object TextListScreen : Screen("text_list_screen")
    object TextDetailScreen : Screen("text_detail_screen")
}