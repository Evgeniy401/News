package com.example.myapplication.data.repository

import com.example.myapplication.domain.dao.UserDao
import com.example.myapplication.domain.entity.User
import com.example.myapplication.domain.utill.Result
import java.util.UUID
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val userDao: UserDao
) {
    suspend fun login(email: String, password: String): Result {
        val loginUser = userDao.login(email, password)
        val result = if (loginUser == null) Result.Failure<Unit>("Invalid login")
        else Result.Success<Unit>("Successful authorization")

        return result
    }

    suspend fun register(username: String, email: String, password: String): Result {
        if (userDao.getUserByEmail(email) != null)
            return Result.Failure<Unit>(msg = "User with this email already exists")

        val user = User(
            id = UUID.randomUUID().toString(),
            username = username,
            email = email,
            password = password,
        )
        userDao.addUser(user)
        return Result.Success<Unit>(msg = "Successful registration")
    }
}