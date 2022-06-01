package com.example.newsappwithmvvm.domain.repository

import androidx.lifecycle.LiveData
import com.example.newsappwithmvvm.data.model.APIResponse
import com.example.newsappwithmvvm.data.model.Article
import com.example.newsappwithmvvm.data.util.Resource
import kotlinx.coroutines.flow.Flow


interface NewsRepository {
    suspend fun getNewsHeadlines():Resource<APIResponse>
    suspend fun getSearchedNews(searchQuery:String):Resource<APIResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}