package com.example.myapplication.presentation.screen.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myapplication.presentation.screen.state.RegisterScreenEvent
import com.example.myapplication.presentation.screen.state.RegisterScreenState

class RegisterScreenViewModel : ViewModel() {
    var state by mutableStateOf(RegisterScreenState())
        private set

    fun onEvent(event: RegisterScreenEvent) {
        when (event) {
            is RegisterScreenEvent.UsernameUpdated -> state = state.copy(username = event.newUsername)
            is RegisterScreenEvent.PasswordUpdated -> state = state.copy(password = event.newPassword)
            is RegisterScreenEvent.EmailUpdated -> state = state.copy(email = event.newEmail)
        }
    }
}