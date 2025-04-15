package com.example.habittrackerapp.ui.screens.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.habittrackerapp.R
import com.example.habittrackerapp.ui.components.background.GradientBackground
import com.example.habittrackerapp.ui.screens.onboarding.components.OnboardingIndicator
import com.example.habittrackerapp.ui.screens.onboarding.components.OnboardingPageItem
import com.example.habittrackerapp.ui.screens.onboarding.components.SocialLoginButton
import com.example.habittrackerapp.ui.screens.onboarding.model.OnboardingPageModel
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(navController: NavController) {
    GradientBackground {
        val pages = listOf(
            OnboardingPageModel.FirstPage,
            OnboardingPageModel.SecondPage,
            OnboardingPageModel.ThirdPage
        )
        val pagerState = rememberPagerState(initialPage = 0) { pages.size }

        Column(modifier = Modifier.fillMaxSize()) {
            OnboardingPager(pages = pages, pagerState = pagerState)
            OnboardingBottomSection(navController = navController)
        }
    }
}

@Composable
fun OnboardingPager(pages: List<OnboardingPageModel>, pagerState: PagerState) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) { index ->
            OnboardingPageItem(onboardingPageModel = pages[index])
        }

        Spacer(modifier = Modifier.height(16.dp))

        OnboardingIndicator(
            pageSize = pages.size,
            currentPage = pagerState.currentPage,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun OnboardingBottomSection(navController: NavController) {
    Button(
        onClick = { navController.navigate("login") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(50.dp),
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
            onClick = { /* TODO: Google Login */ }
        )
        SocialLoginButton(
            iconResId = R.drawable.facebook_logo,
            text = "Facebook",
            onClick = { /* TODO: Facebook Login */ }
        )
    }

    Text(
        text = "By continuing you agree to Terms of Services & Privacy Policy",
        color = Color.White,
        fontSize = 14.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen(navController = rememberNavController())
}
