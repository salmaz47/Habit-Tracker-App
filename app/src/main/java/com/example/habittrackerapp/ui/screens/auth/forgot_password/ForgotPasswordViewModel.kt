package com.example.habittrackerapp.ui.screens.auth.forgot_password

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ForgotPasswordViewModel : ViewModel() {

    var state by mutableStateOf(ForgotPasswordFormState())
        private set

    fun onEmailChanged(newEmail: String) {
        state = state.copy(
            email = newEmail,
            emailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(newEmail).matches()
        )
    }

    fun canSubmit(): Boolean {
        return state.emailValid && state.email.isNotBlank()
    }

    fun sendPasswordReset(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            state = state.copy(isLoading = true)

            // simulate delay
            delay(1500)

            if (state.email.contains("@")) {
                onSuccess()
            } else {
                onError("Failed to send reset email. Try again.")
            }

            state = state.copy(isLoading = false)
        }
    }
}
