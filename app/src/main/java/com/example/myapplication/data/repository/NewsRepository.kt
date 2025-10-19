package com.example.myapplication.data.repository

import com.example.myapplication.domain.model.NewsItem
import kotlinx.datetime.LocalDateTime

class NewsRepository {
    suspend fun loadNews(): List<NewsItem> {
        return listOf(
            NewsItem(
                id = "1",
                title = "Запуск новой версии Android Studio",
                description = "Google представил новую версию Android Studio с улучшенной производительностью и новыми инструментами для разработки.",
                publishedBy = "Android Developers Blog",
                publishedAt = LocalDateTime(2024, 1, 15, 14, 30),
                imageUrl = "https://papik.pro/uploads/posts/2021-11/1636195125_13-papik-pro-p-prostie-logotipi-foto-16.jpg",
                isFavorite = true
            ),
            NewsItem(
                id = "2",
                title = "Kotlin 2.0: Что нового в обновлении",
                description = "JetBrains анонсировал выход Kotlin 2.0 с новыми возможностями для мультиплатформенной разработки.",
                publishedBy = "Kotlin Blog",
                publishedAt = LocalDateTime(2024, 1, 14, 10, 15),
                imageUrl = "https://papik.pro/uploads/posts/2021-11/1636195092_1-papik-pro-p-prostie-logotipi-foto-1.jpg",
                isFavorite = false
            ),
            NewsItem(
                id = "3",
                title = "Композерный UI: Будущее Android разработки",
                description = "Jetpack Compose продолжает набирать популярность среди разработчиков благодаря своей простоте и мощности.",
                publishedBy = "Android Authority",
                publishedAt = LocalDateTime(2024, 1, 13, 16, 45),
                imageUrl = "https://papik.pro/uploads/posts/2021-11/1636195107_8-papik-pro-p-prostie-logotipi-foto-10.jpg",
                isFavorite = true
            )
        )
    }
}