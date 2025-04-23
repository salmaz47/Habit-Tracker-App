package com.example.habittrackerapp.ui.screens.auth.register

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.habittrackerapp.utils.isValidEmail
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class RegisterViewModel : ViewModel() {

    var registerState by mutableStateOf(RegisterFormState())
        private set

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun onFirstNameChanged(value: String) {
        registerState = registerState.copy(firstName = value)
    }

    fun onLastNameChanged(value: String) {
        registerState = registerState.copy(lastName = value)
    }

    fun onEmailChanged(value: String) {
        val isValid = value.isValidEmail()
        registerState = registerState.copy(email = value, emailValid = isValid)
    }

    fun onPasswordChanged(value: String) {
        val match = value == registerState.confirmPassword
        registerState = registerState.copy(password = value, passwordsMatch = match)
    }

    fun onConfirmPasswordChanged(value: String) {
        val match = registerState.password == value
        registerState = registerState.copy(confirmPassword = value, passwordsMatch = match)
    }


    fun canRegister(): Boolean {
        return registerState.firstName.isNotBlank() &&
                registerState.lastName.isNotBlank() &&
                registerState.emailValid &&
                registerState.password.length >= 6 &&
                registerState.passwordsMatch
    }

    fun register(onSuccess: () -> Unit, onError: (String) -> Unit) {
        val email = registerState.email.trim()
        val password = registerState.password

        if (email.isBlank() || password.isBlank()) {
            onError("Email and password must not be empty")
            return
        }

        registerState = registerState.copy(isLoading = true)

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    sendVerificationEmail(onSuccess, onError)
                } else {
                    registerState = registerState.copy(isLoading = false)

                    when (task.exception) {
                        is FirebaseAuthUserCollisionException -> onError("User already exists")
                        is FirebaseAuthWeakPasswordException -> onError("Weak Password, try entering a strong password")
                        is FirebaseAuthInvalidCredentialsException -> onError("Invalid Email")
                        else -> onError(task.exception?.message ?: "Registration failed")
                    }
                }
            }
    }

    private fun sendVerificationEmail(onSuccess: () -> Unit, onError: (String) -> Unit) {
        val user = auth.currentUser
        user?.sendEmailVerification()
            ?.addOnCompleteListener { task ->
                registerState = registerState.copy(isLoading = false)

                if (task.isSuccessful) {
                    onSuccess()
                } else {
                    onError(task.exception?.message ?: "Failed to send verification email")
                }
            }
    }
}
