package com.example.habittrackerapp.navigation

import HabitsScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.habittrackerapp.ui.screens.createAccount.CreateAccountScreen
import com.example.habittrackerapp.ui.screens.gender.GenderScreen
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
        composable(route = Screen.CreateAccount.route) {
            CreateAccountScreen(navController)
        }

        composable(route= Screen.Gender.route) {
            GenderScreen(navController)
        }
        composable(route= Screen.Habits.route) {
            HabitsScreen(navController)
        }
    }
}