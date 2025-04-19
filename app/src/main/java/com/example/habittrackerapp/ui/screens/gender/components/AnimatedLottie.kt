package com.example.habittrackerapp.ui.screens.gender.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.*

@Composable
fun AnimatedLottie(animationFileName: String, modifier: Modifier = Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset(animationFileName))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

    AnimatedVisibility(
        visible = true,
        enter = fadeIn(animationSpec = tween(1200)) + scaleIn(initialScale = 0.3f, animationSpec = tween(1200)),
    ) {
        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = modifier
        )
    }
}
