package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.UserRepository
import com.example.myapplication.data.network.NetworkModule
import com.example.myapplication.ui.AuthScreen
import com.example.myapplication.ui.AuthViewModel

class MainActivity : ComponentActivity() {
    private val authViewModel: AuthViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val repository = UserRepository(NetworkModule.userApi)
                @Suppress("UNCHECKED_CAST")
                return AuthViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuthScreen(viewModel = authViewModel)
        }
    }
}
