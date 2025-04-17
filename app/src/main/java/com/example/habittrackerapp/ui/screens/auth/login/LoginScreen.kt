package com.example.habittrackerapp.ui.screens.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.habittrackerapp.R
import com.example.habittrackerapp.ui.screens.auth.components.*
import com.example.habittrackerapp.ui.theme.Blue

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = viewModel()) {
    val state = viewModel.loginState
    val loginError = remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEDEDF3))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            AuthHeader(
                title = "Login",
                subtitle = "Welcome back!",
                onBackClick = { navController.popBackStack() }
            )

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

            AuthPasswordField(
                value = state.password,
                onValueChange = viewModel::onPasswordChanged,
                label = "Password",
                modifier = Modifier.fillMaxWidth(),
                supportingText = if (state.password.isNotBlank() && state.password.length < 6) "Password should be at least 6 characters" else null
            )

            // Error message if login fails
            loginError.value?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = it, color = Color.Red)
            }

            // Forgot Password Link
            Text(
                text = "Forgot Password?",
                color = Color.Blue,
                fontSize = 16.sp,
                modifier = Modifier
                    .clickable {
                        navController.navigate("forgot_password")
                    },
                textDecoration = TextDecoration.Underline
            )

            Spacer(modifier = Modifier.height(32.dp))

            AuthButton(
                text = "Login",
                onClick = {
                    viewModel.login(
                        onSuccess = {
                            loginError.value = null
                            navController.navigate("home")
                        },
                        onError = { error ->
                            loginError.value = error
                        }
                    )
                },
                enabled = !state.isLoading
            )

            Spacer(modifier = Modifier.height(32.dp))
            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            AuthButtonWithIcon(
                text = "Continue with Google",
                iconResourceId = R.drawable.google_logo,
                onClick = {}
            )

            Spacer(modifier = Modifier.height(32.dp))

            AuthButtonWithIcon(
                text = "Continue with Facebook",
                iconResourceId = R.drawable.facebook_logo,
                onClick = {}
            )

            Spacer(modifier = Modifier.height(32.dp))

            ClickableTextWithAction(
                mainText = "Don't have an account? ",
                actionText = "Register",
                onClickAction = { navController.navigate("register") },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}
