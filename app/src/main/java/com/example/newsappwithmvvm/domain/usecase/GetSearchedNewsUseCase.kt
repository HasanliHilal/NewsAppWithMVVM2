package com.example.newsappwithmvvm.domain.usecase

import com.example.newsappwithmvvm.data.model.APIResponse
import com.example.newsappwithmvvm.data.util.Resource
import com.example.newsappwithmvvm.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(country:String,searchQuery:String,page:Int): Resource<APIResponse> {
        return  newsRepository.getSearchedNews(country,searchQuery,page)
    }
}