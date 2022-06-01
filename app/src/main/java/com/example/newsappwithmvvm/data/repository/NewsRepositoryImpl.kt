package com.example.newsappwithmvvm.data.repository

import com.example.newsappwithmvvm.data.model.APIResponse
import com.example.newsappwithmvvm.data.model.Article
import com.example.newsappwithmvvm.data.repository.dataSource.NewsRemoteDataSource
import com.example.newsappwithmvvm.data.util.Resource
import com.example.newsappwithmvvm.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private  val newsRemoteDataSource: NewsRemoteDataSource
):NewsRepository {
    override suspend fun getNewsHeadlines(): Resource<APIResponse> {
        return  responseToResource(newsRemoteDataSource.getTopHeadlines())
    }
    private fun responseToResource(response: Response<APIResponse>):Resource<APIResponse>{
        if(response.isSuccessful){
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }
    override suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }
}