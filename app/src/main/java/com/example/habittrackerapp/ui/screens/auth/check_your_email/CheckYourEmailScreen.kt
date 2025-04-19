package com.example.habittrackerapp.ui.screens.auth.check_your_email

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.habittrackerapp.navigation.Screen
import com.example.habittrackerapp.ui.components.custom_snackbar.CustomSnackbar
import com.example.habittrackerapp.ui.screens.auth.components.AuthButton
import com.example.habittrackerapp.ui.screens.auth.components.AuthHeader
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

@Composable
fun CheckYourEmailScreen(
    navController: NavController
) {
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { CustomSnackbar(snackbarHostState = snackbarHostState) },
        containerColor = Color(0xFFEDEDF3)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(paddingValues),
            horizontalAlignment = Alignment.Start
        ) {
            // Header Section
            AuthHeader(
                title = "Check Your Email",
                subtitle = "We've sent you a verification email. Please check your inbox and click the link",
                onBackClick = {navController.popBackStack()}
            )

            // Register Button Section
            Spacer(modifier = Modifier.height(32.dp))
            AuthButton(
                text = "I have verified",
                onClick = {
                    val user = FirebaseAuth.getInstance().currentUser
                    user?.reload()?.addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            if (user.isEmailVerified) {
                                navController.navigate(Screen.Gender.route) {
                                    popUpTo(Screen.CheckYourEmail.route) { inclusive = true }
                                }
                            } else {
                                coroutineScope.launch {
                                    snackbarHostState.showSnackbar("Email not verified yet. Please check again later.")
                                }
                            }
                        } else {
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar("Failed to check verification. Try again.")
                            }
                        }
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CheckYourEmailScreenPreview() {
    CheckYourEmailScreen(navController = rememberNavController())
}
