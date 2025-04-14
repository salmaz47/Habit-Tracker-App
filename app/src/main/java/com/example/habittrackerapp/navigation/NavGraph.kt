package com.example.habittrackerapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.habittrackerapp.ui.screens.home.HomeScreen
import com.example.habittrackerapp.ui.screens.login.LoginScreen
import com.example.habittrackerapp.ui.screens.onboarding.OnboardingScreen
import com.example.habittrackerapp.ui.screens.splash.SplashScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(route = Screen.Onboarding.route) {
            OnboardingScreen(navController)
        }
        composable(route = Screen.Login.route) {
            LoginScreen(navController)
        }
    }
}