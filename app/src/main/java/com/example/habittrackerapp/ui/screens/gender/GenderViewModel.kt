package com.example.habittrackerapp.ui.screens.gender

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GenderViewModel : ViewModel() {
    var selectedGender by mutableStateOf<Gender?>(null)
        private set

    fun selectGender(gender: Gender) {
        selectedGender = gender
    }
}
