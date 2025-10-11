package com.example.myapplication.presentation.screen.login

import com.example.myapplication.domain.utill.Result


sealed class LoginScreenEvent {
    data class EmailUpdated(val newEmail: String) : LoginScreenEvent()
    data class PasswordUpdated(val newPassword: String) : LoginScreenEvent()
    data object LoginBtnClicked : LoginScreenEvent()
}

data class LoginScreenState(
    val email: String = "",
    val password: String = "",
    val loginResult: Result? = null

)
