package com.example.newsappwithmvvm.presentation.di

import com.example.newsappwithmvvm.data.api.NewsAPIService
import com.example.newsappwithmvvm.data.repository.dataSource.NewsRemoteDataSource
import com.example.newsappwithmvvm.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Provides
    @Singleton
    fun provideNewsRemoteDataSource(newsAPIService: NewsAPIService):NewsRemoteDataSource {
           return NewsRemoteDataSourceImpl(newsAPIService)
    }
}