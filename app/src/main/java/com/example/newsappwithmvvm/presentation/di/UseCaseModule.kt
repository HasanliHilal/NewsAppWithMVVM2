package com.example.newsappwithmvvm.presentation.di

import com.example.newsappwithmvvm.domain.repository.NewsRepository
import com.example.newsappwithmvvm.domain.usecase.GetNewsHeadlinesUseCase
import com.example.newsappwithmvvm.domain.usecase.GetSearchedNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    @Singleton
    fun provideNewsHeadlinesUseCase(newsRepository: NewsRepository):GetNewsHeadlinesUseCase{
        return GetNewsHeadlinesUseCase(newsRepository)

    }

    @Provides
    @Singleton
    fun provideGetSearchedUseCase(newsRepository: NewsRepository):GetSearchedNewsUseCase{
        return GetSearchedNewsUseCase(newsRepository)

    }
}