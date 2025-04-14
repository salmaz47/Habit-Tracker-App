package com.example.habittrackerapp.data

import androidx.annotation.DrawableRes
import com.example.habittrackerapp.R

sealed class OnboardingPage(
    val title: String,
    val description: String,
    @DrawableRes val imageRes: Int
) {
    data object FirstPage : OnboardingPage(
            title = "Create \nGood Habits",
            description = "Change your life by slowly adding new healthy habits and sticking to them.",
            imageRes = R.drawable.onboarding_create
    )

    data object SecondPage : OnboardingPage(
            title = "Track \nYour Progress",
            description = "Everyday you become one step closer to your goal. Don't give Up!",
            imageRes = R.drawable.onboarding_track
    )

    data object ThirdPage : OnboardingPage(
            title = "Stay Together \nand Strong",
            description = "Find friends to discuss common topics. Complete challenges together.",
            imageRes = R.drawable.onboarding_together
    )

}