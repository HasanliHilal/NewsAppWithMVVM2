package com.example.newsappwithmvvm.domain.usecase

import com.example.newsappwithmvvm.data.model.Article
import com.example.newsappwithmvvm.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun  execute(article: Article) = newsRepository.deleteNews(article)
}