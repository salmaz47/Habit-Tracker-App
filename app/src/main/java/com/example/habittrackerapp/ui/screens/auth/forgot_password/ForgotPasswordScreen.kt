package com.example.habittrackerapp.ui.screens.auth.forgot_password

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.habittrackerapp.ui.components.custom_snackbar.CustomSnackbar
import com.example.habittrackerapp.ui.screens.auth.components.AuthButton
import com.example.habittrackerapp.ui.screens.auth.components.AuthHeader
import com.example.habittrackerapp.ui.screens.auth.components.AuthTextField
import kotlinx.coroutines.launch
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ForgotPasswordScreen(
    navController: NavController,
    viewModel: ForgotPasswordViewModel = viewModel()
) {
    val state = viewModel.state
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Surface(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFEDEDF3))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                // Header Section
                AuthHeader(
                    title = "Forgot Password?",
                    subtitle = "Recover your password if you have forgotten it.",
                    onBackClick = {
                        navController.popBackStack()
                    }
                )

                // Input Section
                AuthTextField(
                    value = state.email,
                    onValueChange = viewModel::onEmailChanged,
                    label = "Email",
                    leadingIcon = Icons.Default.Email,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    isError = state.email.isNotBlank() && !state.emailValid,
                    supportingText = if (state.email.isNotBlank() && !state.emailValid) "Please enter a valid email" else null
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Button Section
                AuthButton(
                    text = "Reset Password",
                    onClick = {
                        viewModel.sendPasswordReset(
                            onSuccess = {
                                coroutineScope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = "Reset email sent. Please check your inbox.",
                                        actionLabel = "Success"
                                    )
                                }
                            },
                            onError = {
                                coroutineScope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = it,
                                        actionLabel = "Error"
                                    )
                                }
                            }
                        )
                    },
                    enabled = !state.isLoading && viewModel.canSubmit()
                )
            }

            // Snackbar Section
            CustomSnackbar(
                snackbarHostState = snackbarHostState,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ForgotPasswordScreenPreview() {
    ForgotPasswordScreen(navController = rememberNavController())
}
