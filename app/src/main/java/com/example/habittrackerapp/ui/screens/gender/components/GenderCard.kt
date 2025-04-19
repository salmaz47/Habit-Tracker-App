package com.example.habittrackerapp.ui.screens.gender.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import com.example.habittrackerapp.ui.screens.gender.Gender

@Composable
fun GenderCard(
    gender: Gender,
    animationFileName: String,
    selected: Boolean,
    selectedBackgroundColor: Color,
    onClick: () -> Unit
) {
    val background = if (selected) selectedBackgroundColor else Color.White
    val contentColor = if (selected) Color.White else Color.Black

    val composition by rememberLottieComposition(
        LottieCompositionSpec.Asset(animationFileName)
    )
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .width(160.dp)
                .height(160.dp)
                .clip(RoundedCornerShape(25.dp))
                .background(background)
                .clickable { onClick() }
                .padding(horizontal = 32.dp, vertical = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            if (composition != null) {
                LottieAnimation(
                    composition = composition,
                    progress = { progress },
                    modifier = Modifier.size(100.dp)
                )
            } else {
                Text("Loading...", color = contentColor)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = gender.name,
            fontSize = 24.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun GenderCardPreview() {
    var selectedGender by remember { mutableStateOf<Gender?>(null) }

    GenderCard(
        gender = Gender.Female,
        animationFileName = "pink_female_icon.json",
        selected = selectedGender == Gender.Female,
        selectedBackgroundColor = Color(0xFFFF6699),
        onClick = { selectedGender = Gender.Female }
    )
}
