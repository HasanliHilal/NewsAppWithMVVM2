package com.example.newsappwithmvvm.data.repository.dataSource

import com.example.newsappwithmvvm.data.model.Article

interface NewsLocalDataSource {
    suspend fun saveArticleToDB(article: Article)
}