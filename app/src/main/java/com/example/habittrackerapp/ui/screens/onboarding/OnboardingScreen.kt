package com.example.habittrackerapp.ui.screens.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.habittrackerapp.R
import com.example.habittrackerapp.data.OnboardingPage
import com.example.habittrackerapp.ui.components.background.GradientBackground
import com.example.habittrackerapp.ui.screens.onboarding.components.OnboardingIndicator
import com.example.habittrackerapp.ui.screens.onboarding.components.OnboardingPageItem
import com.example.habittrackerapp.ui.screens.onboarding.components.SocialLoginButton
import com.example.habittrackerapp.ui.theme.Blue

@Composable
fun OnboardingScreen(navController: NavController) {

    GradientBackground{
        val pages = listOf(
            OnboardingPage.FirstPage,
            OnboardingPage.SecondPage,
            OnboardingPage.ThirdPage
        )

        val pagerState = rememberPagerState(initialPage = 0) { pages.size }

        Box(modifier = Modifier.fillMaxSize()) {

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top
            ) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(550.dp),
                    verticalAlignment = Alignment.Top
                ){ index ->
                    OnboardingPageItem(onboardingPage = pages[index])
                }

                Spacer(modifier = Modifier.height(16.dp))

                OnboardingIndicator(
                    pageSize = pages.size,
                    currentPage = pagerState.currentPage,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { navController.navigate("login")},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.login_logo),
                            contentDescription = "Arrow",
                            tint = Color.Gray,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Continue with E-mail",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                ) {
                    SocialLoginButton(
                        iconResId = R.drawable.google_logo,
                        text = "Google",
                        onClick = { /* действие при нажатии */ }
                    )
                    SocialLoginButton(
                        iconResId = R.drawable.facebook_logo,
                        text = "Facebook",
                        onClick = { /* действие при النقر على Facebook */ }
                    )
                }

                Text(
                    text = "By continuing you agree to Terms of Services & Privacy Policy",
                    color = Color.White,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true, device = "id:pixel_7_pro")
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen(navController = NavController(LocalContext.current))
}

