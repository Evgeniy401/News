package com.example.myapplication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.domain.dao.UserDao
import com.example.myapplication.domain.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDataBase: RoomDatabase() {
    abstract fun getUserDao(): UserDao
}