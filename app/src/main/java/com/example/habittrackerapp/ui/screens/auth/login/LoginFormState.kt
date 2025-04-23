package com.example.habittrackerapp.ui.screens.auth.login

data class LoginFormState(
    val email: String = "",
    val password: String = "",
    val emailValid: Boolean = true,
    val isLoading: Boolean = false
)
