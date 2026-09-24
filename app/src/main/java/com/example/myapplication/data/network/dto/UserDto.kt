package com.example.myapplication.data.network.dto

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("id") val id: String? = null,
    @SerializedName("fullname") val fullname: String? = null,
    @SerializedName("email") val email: String? = null,
    @SerializedName("password") val password: String? = null,
    @SerializedName("birthdate") val birthdate: String? = null
)

data class NewUserDto(
    @SerializedName("fullname") val fullname: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("birthdate") val birthdate: String
)
