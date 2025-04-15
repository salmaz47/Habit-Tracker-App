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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.habittrackerapp.navigation.Screen
import com.example.habittrackerapp.ui.CustomTextField
import com.example.habittrackerapp.ui.PrimaryButton

@Composable
fun CreateAccountScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var birthdate by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp)
            .background(Color(0xFFf6f9ff))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.White),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFf6f9ff))
                ) {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Create Account",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 16.dp,
                    end = 20.dp, start = 20.dp, bottom = 30.dp
                ),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(24.dp))
                CustomTextField(
                    label = "Name",
                    value = name,
                    onValueChange = { name = it },
                    placeholder = "Enter your name",
                    trailingIcon = {
                        if (name.isNotEmpty()) {
                            IconButton(onClick = { name = "" }) {
                                Icon(Icons.Default.Close, contentDescription = "Clear")
                            }
                        }
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                CustomTextField(
                    label = "Surname",
                    value = surname,
                    onValueChange = { surname = it },
                    placeholder = "Enter your surname",
                    trailingIcon = {
                        if (surname.isNotEmpty()) {
                            IconButton(onClick = { surname = "" }) {
                                Icon(Icons.Default.Close, contentDescription = "Clear")
                            }
                        }
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                CustomTextField(
                    label = "Birthdate",
                    value = birthdate,
                    onValueChange = { birthdate = it },
                    placeholder = "mm/dd/yyyy",
                    trailingIcon = {
                        if (birthdate.isNotEmpty()) {
                            IconButton(onClick = { birthdate = "" }) {
                                Icon(Icons.Default.Close, contentDescription = "Clear")
                            }
                        }
                    }
                )


            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                PrimaryButton(text = "Next",enabled = name.isNotBlank() && surname.isNotBlank() && birthdate.isNotBlank()) {
                    // Handle navigation or validation
                   navController.navigate(Screen.Gender.route)
                }
            }

        }
    }
}