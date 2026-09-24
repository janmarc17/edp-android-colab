package com.example.myapplication.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    private const val BASE_URL = "https://6a9b85920ad174e139e8b0f2.mockapi.io/chat-messaging/api/v1/"

    val userApi: UserApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UserApiService::class.java)

    val apiService: UserApiService get() = userApi
}
