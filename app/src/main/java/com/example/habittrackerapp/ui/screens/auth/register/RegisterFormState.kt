package com.example.habittrackerapp.ui.screens.auth.register

data class RegisterFormState(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val emailValid: Boolean = true,
    val passwordsMatch: Boolean = true,
    val isLoading: Boolean = false
)
