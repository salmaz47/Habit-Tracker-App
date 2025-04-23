package com.example.habittrackerapp.ui.screens.auth.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
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
import com.example.habittrackerapp.ui.screens.auth.components.*
import com.example.habittrackerapp.ui.theme.Blue
import kotlinx.coroutines.launch
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.habittrackerapp.navigation.Screen
import com.example.habittrackerapp.ui.components.custom_snackbar.CustomSnackbar

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = viewModel()
) {
    val state = viewModel.registerState
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { CustomSnackbar(snackbarHostState = snackbarHostState) },
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFEDEDF3))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {

                AuthHeader(
                    title = "Register",
                    subtitle = "Create an account",
                    onBackClick = { navController.popBackStack() }
                )

                // Name Fields
                Row(modifier = Modifier.fillMaxWidth()) {
                    AuthTextField(
                        value = state.firstName,
                        onValueChange = viewModel::onFirstNameChanged,
                        label = "First Name",
                        leadingIcon = Icons.Default.Person,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                    )

                    AuthTextField(
                        value = state.lastName,
                        onValueChange = viewModel::onLastNameChanged,
                        label = "Last Name",
                        leadingIcon = Icons.Default.Person,
                        modifier = Modifier.weight(1f)
                    )
                }

                // Email Field
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

                // Password Fields
                AuthPasswordField(
                    value = state.password,
                    onValueChange = viewModel::onPasswordChanged,
                    label = "Password",
                    modifier = Modifier.fillMaxWidth(),
                    supportingText = if (state.password.isNotBlank() && state.password.length < 6) "Password should be at least 6 characters" else null
                )

                AuthPasswordField(
                    value = state.confirmPassword,
                    onValueChange = viewModel::onConfirmPasswordChanged,
                    label = "Confirm Password",
                    modifier = Modifier.fillMaxWidth(),
                    isError = !state.passwordsMatch,
                    supportingText = if (!state.passwordsMatch) "Passwords don't match" else null
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Register Button
                AuthButton(
                    text = "Register",
                    onClick = {
                        viewModel.register(
                            onSuccess = {
                                navController.navigate(Screen.CheckYourEmail.route)
                            },
                            onError = { errorMsg ->
                                coroutineScope.launch {
                                    snackbarHostState.showSnackbar(errorMsg)
                                }
                            }
                        )
                    },
                    enabled = viewModel.canRegister()
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Login prompt
                ClickableTextWithAction(
                    mainText = "Already have an account? ",
                    actionText = "Login",
                    onClickAction = { navController.popBackStack() },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(32.dp))
            }

            // Loading Indicator Overlay
            if (state.isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0x88000000)),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = Blue)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RegisterScreenPreview() {
    RegisterScreen(navController = rememberNavController())
}
