package com.example.habittrackerapp.ui.screens.gender

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.habittrackerapp.navigation.Screen
import com.example.habittrackerapp.ui.components.primary_button.PrimaryButton
import com.example.habittrackerapp.ui.screens.gender.components.AnimatedLottie
import com.example.habittrackerapp.ui.screens.gender.components.GenderCard

@Composable
fun GenderScreen(
    navController: NavController,
    viewModel: GenderViewModel = viewModel()
) {
    val selectedGender = viewModel.selectedGender

    val genderToAnimation = mapOf(
        Gender.Male to "man.json",
        Gender.Female to "female.json"
    )

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEDEDF3))
            .padding(bottom = 32.dp, start = 10.dp, end = 10.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentAlignment = Alignment.Center
            ) {
                selectedGender?.let {
                    AnimatedLottie(animationFileName = genderToAnimation[it] ?: "")
                }
            }

            Text(
                text = "Select your Gender",
                fontSize = 32.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 20.dp)
            )

            Spacer(modifier = Modifier.height(96.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                GenderCard(
                    gender = Gender.Male,
                    animationFileName = if (selectedGender == Gender.Male) "white_male_icon.json" else "green_male_icon.json",
                    selected = selectedGender == Gender.Male,
                    selectedBackgroundColor = Color(0xFF009D90),
                    onClick = { viewModel.selectGender(Gender.Male) }
                )

                GenderCard(
                    gender = Gender.Female,
                    animationFileName = if (selectedGender == Gender.Female) "white_female_icon.json" else "pink_female_icon.json",
                    selected = selectedGender == Gender.Female,
                    selectedBackgroundColor = Color(0xFFFF6699),
                    onClick = { viewModel.selectGender(Gender.Female) }
                )
            }
        }


        AnimatedVisibility(
            visible = selectedGender != null,
            enter = slideInVertically(
                initialOffsetY = { it / 2 },
                animationSpec = tween(durationMillis = 200)
            ) + fadeIn(animationSpec = tween(200)),


            exit = slideOutVertically(
                targetOffsetY = { it / 2 },
                animationSpec = tween(durationMillis = 200)
            ) + fadeOut(animationSpec = tween(200))
        ) {
            PrimaryButton(
                text = "Next",
                onClick = {
                    navController.navigate(Screen.Habits.route)
                },
                modifier = Modifier.padding(bottom = 32.dp)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GenderScreenPreview() {
    GenderScreen(navController = rememberNavController())
}
