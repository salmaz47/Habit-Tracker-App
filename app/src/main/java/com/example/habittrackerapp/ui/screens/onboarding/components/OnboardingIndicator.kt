package com.example.habittrackerapp.ui.screens.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OnboardingIndicator(
    pageSize: Int,
    currentPage: Int,
    selectedColor: Color = Color.White,
    unselectedColor: Color = Color.LightGray,
    modifier: Modifier = Modifier
) {


    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        modifier = modifier
    ) {
        repeat(pageSize) {
            Box(
                modifier = Modifier
                    .height(14.dp)
                    .width(if (it == currentPage) 32.dp else 14.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (it == currentPage) selectedColor else unselectedColor)
            )
        }
    }


}


@Preview(showBackground = true)
@Composable
fun OnboardingIndicatorPreview1() {

    OnboardingIndicator(pageSize = 3, currentPage = 0)

}

@Preview(showBackground = true)
@Composable
fun OnboardingIndicatorPreview2() {

    OnboardingIndicator(pageSize = 3, currentPage = 1)

}

@Preview(showBackground = true)
@Composable
fun OnboardingIndicatorPreview3() {

    OnboardingIndicator(pageSize = 3, currentPage = 2)

}