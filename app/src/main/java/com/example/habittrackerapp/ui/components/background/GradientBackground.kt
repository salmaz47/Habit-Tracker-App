package com.example.habittrackerapp.ui.components.background

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.habittrackerapp.R
import com.example.habittrackerapp.ui.theme.Blue

@Composable
fun GradientBackground(
    modifier: Modifier = Modifier,
    showCircle: Boolean = true,
    content: @Composable () -> Unit = {}
) {
    val gradientColors = listOf(Color(0xFF5611D9), Color.Red)

    val gradientBrush = Brush.linearGradient(
        colors = gradientColors,
        start = Offset(0f, 0f),
        end = Offset(
            LocalDensity.current.run { 700.dp.toPx() },
            LocalDensity.current.run { 500.dp.toPx() }
        )
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(brush = gradientBrush)
    ) {
        if (showCircle) {
            Image(
                painter = painterResource(id = R.drawable.circle_background),
                alpha = 0.4f,
                contentDescription = "Circle Background",
                modifier = Modifier.align(Alignment.Center),
            )
        }

        content()
    }
}
