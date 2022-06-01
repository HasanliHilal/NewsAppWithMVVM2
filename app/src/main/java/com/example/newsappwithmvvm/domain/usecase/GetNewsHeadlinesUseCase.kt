package com.example.newsappwithmvvm.domain.usecase

import com.example.newsappwithmvvm.data.model.APIResponse
import com.example.newsappwithmvvm.data.util.Resource
import com.example.newsappwithmvvm.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private  val newsRepository: NewsRepository) {
    suspend fun execute():Resource<APIResponse>{
        return  newsRepository.getNewsHeadlines()
    }
}