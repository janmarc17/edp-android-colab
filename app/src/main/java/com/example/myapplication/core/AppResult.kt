package com.example.myapplication.core

sealed interface AppResult<out T> {
    data class Success<out T>(val data: T) : AppResult<T>

    sealed interface Failure : AppResult<Nothing> {
        object NoInternet : Failure
        object Timeout : Failure
        object WrongLogin : Failure
        object EmailTaken : Failure
        data class Unknown(val msg: String) : Failure
    }
}
