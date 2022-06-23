package com.example.newsappwithmvvm.presentation.di

import com.example.newsappwithmvvm.data.repository.NewsRepositoryImpl
import com.example.newsappwithmvvm.data.repository.dataSource.NewsLocalDataSource
import com.example.newsappwithmvvm.data.repository.dataSource.NewsRemoteDataSource
import com.example.newsappwithmvvm.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun providesNewsRepository(newsRemoteDataSource: NewsRemoteDataSource,newsLocalDataSource: NewsLocalDataSource):NewsRepository{
        return NewsRepositoryImpl(newsRemoteDataSource, newsLocalDataSource )
    }

}