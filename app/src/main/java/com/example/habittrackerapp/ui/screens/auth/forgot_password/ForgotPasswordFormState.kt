package com.example.habittrackerapp.ui.screens.auth.forgot_password

data class ForgotPasswordFormState(
    val email: String = "",
    val emailValid: Boolean = true,
    val isLoading: Boolean = false
)