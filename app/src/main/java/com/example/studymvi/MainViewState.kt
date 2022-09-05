package com.example.studymvi

data class MainViewState(
    val success: String? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
