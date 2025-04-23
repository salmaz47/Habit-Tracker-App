package com.example.habittrackerapp.ui.screens.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habittrackerapp.ui.screens.onboarding.model.OnboardingPageModel

@Composable
fun OnboardingPageItem(onboardingPageModel: OnboardingPageModel) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        OnboardingImage(imageRes = onboardingPageModel.imageRes)
        OnboardingTitle(titleRes = onboardingPageModel.title)
        Spacer(modifier = Modifier.height(15.dp))
        OnboardingDescription(descriptionRes = onboardingPageModel.description)
    }
}

@Composable
private fun OnboardingImage(imageRes: Int) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = null,
        modifier = Modifier.size(350.dp),
        alignment = Alignment.Center
    )
}

@Composable
private fun OnboardingTitle(titleRes: Int) {
    Text(
        text = stringResource(id = titleRes),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Start,
        lineHeight = 52.sp,
        color = Color.White
    )
}

@Composable
private fun OnboardingDescription(descriptionRes: Int) {
    Text(
        text = stringResource(id = descriptionRes),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        fontSize = 16.sp,
        textAlign = TextAlign.Start,
        lineHeight = 24.sp,
        color = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun FirstPagePreview() {
    OnboardingPageItem(OnboardingPageModel.FirstPage)
}

@Preview(showBackground = true)
@Composable
fun SecondPagePreview() {
    OnboardingPageItem(OnboardingPageModel.SecondPage)
}

@Preview(showBackground = true)
@Composable
fun ThirdPagePreview() {
    OnboardingPageItem(OnboardingPageModel.ThirdPage)
}
