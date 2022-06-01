package com.example.newsappwithmvvm.domain.usecase

import com.example.newsappwithmvvm.data.model.Article
import com.example.newsappwithmvvm.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
    fun execute(): Flow<List<Article>>{
        return  newsRepository.getSavedNews()
    }
}