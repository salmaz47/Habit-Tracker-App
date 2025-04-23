package com.example.habittrackerapp.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Onboarding : Screen("onboarding")
    object Login : Screen("login")
    object ForgotPassword : Screen("forgot_password")
    object Register : Screen("register")
    object CheckYourEmail : Screen("check_your_email")
    object Gender : Screen("gender")
    object Habits : Screen("habits")
    object Home : Screen("home")
    // Add more as needed
}