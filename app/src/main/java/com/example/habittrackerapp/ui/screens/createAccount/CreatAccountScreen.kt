package com.example.habittrackerapp.ui.screens.createAccount

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.habittrackerapp.navigation.Screen
import com.example.habittrackerapp.ui.CustomTextField
import com.example.habittrackerapp.ui.PrimaryButton
import com.example.habittrackerapp.ui.screens.login.LoginScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.habittrackerapp.ui.screens.login.AuthViewModel


@Composable
fun CreateAccountScreen(navController: NavController, viewModel: AuthViewModel = viewModel()) {
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var birthdate by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp)
            .background(Color(0xFFf6f9ff))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column {
                CustomTextField(label = "Name", value = name, onValueChange = { name = it }, placeholder = "Enter your name")
                Spacer(modifier = Modifier.height(12.dp))
                CustomTextField(label = "Surname", value = surname, onValueChange = { surname = it }, placeholder = "Enter your surname")
                Spacer(modifier = Modifier.height(12.dp))
                CustomTextField(label = "Birthdate", value = birthdate, onValueChange = { birthdate = it }, placeholder = "mm/dd/yyyy")
                Spacer(modifier = Modifier.height(12.dp))
                CustomTextField(label = "Email", value = email, onValueChange = { email = it }, placeholder = "Enter your email")
                Spacer(modifier = Modifier.height(12.dp))
                CustomTextField(label = "Password", value = password, onValueChange = { password = it }, placeholder = "Enter your password")

                if (viewModel.errorMessage != null) {
                    Text(
                        text = viewModel.errorMessage ?: "",
                        color = Color.Red,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

            PrimaryButton(
                text = "Next",
                enabled = name.isNotBlank() && surname.isNotBlank() && birthdate.isNotBlank() && email.isNotBlank() && password.isNotBlank()
            ) {
                viewModel.signUp(email, password) {
                    navController.navigate(Screen.Gender.route)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CreateAccountPreview() {
    CreateAccountScreen(navController = NavController(LocalContext.current))
}