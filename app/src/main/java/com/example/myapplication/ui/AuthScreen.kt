package com.example.myapplication.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun AuthScreen(
    viewModel: AuthViewModel
) {
    val state = viewModel.uiState
    var showRegister by rememberSaveable { mutableStateOf(false) }

    when (val currentState = state) {
        is AuthUiState.LoggedIn -> {
            ProfileScreen(
                user = currentState.user,
                onLogout = {
                    viewModel.logout()
                    showRegister = false
                }
            )
        }
        else -> {
            if (showRegister) {
                RegisterScreen(
                    state = currentState,
                    onCreate = { fullName, email, password, birthdate ->
                        viewModel.register(fullName, email, password, birthdate)
                    },
                    onGoToLogin = {
                        viewModel.clearMessage()
                        showRegister = false
                    }
                )
            } else {
                LoginScreen(
                    state = currentState,
                    onLogin = { email, password ->
                        viewModel.login(email, password)
                    },
                    onGoToRegister = {
                        viewModel.clearMessage()
                        showRegister = true
                    }
                )
            }
        }
    }
}
