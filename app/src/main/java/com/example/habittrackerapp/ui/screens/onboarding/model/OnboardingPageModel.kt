package com.example.habittrackerapp.ui.screens.onboarding.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.habittrackerapp.R

sealed class OnboardingPageModel(
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val imageRes: Int
) {
    data object FirstPage : OnboardingPageModel(
            title = R.string.onboarding_title_1,
            description = R.string.onboarding_desc_1,
            imageRes = R.drawable.onboarding_create
    )

    data object SecondPage : OnboardingPageModel(
            title = R.string.onboarding_title_2,
            description = R.string.onboarding_desc_2,
            imageRes = R.drawable.onboarding_track
    )

    data object ThirdPage : OnboardingPageModel(
            title = R.string.onboarding_title_3,
            description = R.string.onboarding_desc_3,
            imageRes = R.drawable.onboarding_together
    )

}