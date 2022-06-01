package com.example.newsappwithmvvm.domain.usecase

import com.example.newsappwithmvvm.data.model.APIResponse
import com.example.newsappwithmvvm.data.model.Article
import com.example.newsappwithmvvm.data.util.Resource
import com.example.newsappwithmvvm.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) = newsRepository.saveNews(article)
}