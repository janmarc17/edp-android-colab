package com.example.myapplication.ui

import com.example.myapplication.domain.model.User

sealed interface AuthUiState {
    object Idle : AuthUiState
    object Loading : AuthUiState
    data class LoggedIn(val user: User) : AuthUiState
    data class AccountCreated(val name: String) : AuthUiState
    data class Error(val message: String) : AuthUiState
}
