package com.example.newsappwithmvvm.data.repository.dataSourceImpl

import com.example.newsappwithmvvm.data.api.NewsAPIService
import com.example.newsappwithmvvm.data.model.APIResponse
import com.example.newsappwithmvvm.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private  val newsAPIService: NewsAPIService,
):NewsRemoteDataSource {
    override suspend fun getTopHeadlines(country:String,page:Int): Response<APIResponse> {
        return  newsAPIService.getTopHeadlines(country,page)
    }
}