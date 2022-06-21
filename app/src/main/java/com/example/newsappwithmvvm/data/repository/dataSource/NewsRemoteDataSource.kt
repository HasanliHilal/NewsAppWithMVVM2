package com.example.newsappwithmvvm.data.repository.dataSource

import com.example.newsappwithmvvm.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(country:String,page:Int):Response<APIResponse>
}