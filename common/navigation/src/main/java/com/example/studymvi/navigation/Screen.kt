package com.example.studymvi.navigation

sealed class Screen(val route: String) {

    object Text : Screen("route_text")

}
