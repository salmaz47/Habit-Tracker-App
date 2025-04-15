package com.example.habittrackerapp.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Onboarding : Screen("onboarding")
    object Login : Screen("login")
    object CreateAccount : Screen("create_account")
    object Gender : Screen("gender")
    object Habits : Screen("habits")
    object Home : Screen("home")
    // Add more as needed
}