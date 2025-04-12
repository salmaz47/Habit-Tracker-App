package com.example.habittrackerapp.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.habittrackerapp.navigation.Screen
import com.example.habittrackerapp.ui.theme.Blue
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate(Screen.Onboarding.route) {
            popUpTo(Screen.Splash.route) { inclusive = true }
        }
    }

    val gradientColors = listOf(
        Color(0xFF5611D9),
        Blue,
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = gradientColors,
                    start = Offset(0f, 0f),
                    end = Offset(
                        LocalDensity.current.run { 700.dp.toPx() },
                        LocalDensity.current.run { 500.dp.toPx() })
                )
            )
    ) {
        Image(
            painter = painterResource(
                id = com.example.habittrackerapp.R.drawable.circle_background
            ),
            alpha = 0.4f,
            contentDescription = "Circle Background",
            modifier = Modifier.align(Alignment.Center),
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(id = com.example.habittrackerapp.R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(76.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "Routiner",
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}


@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(navController = NavController(context = LocalContext.current))
}