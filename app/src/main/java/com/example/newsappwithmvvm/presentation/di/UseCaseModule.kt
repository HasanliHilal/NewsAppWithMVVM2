package com.example.newsappwithmvvm.presentation.di

import com.example.newsappwithmvvm.domain.repository.NewsRepository
import com.example.newsappwithmvvm.domain.usecase.*
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


    @Provides
    @Singleton
    fun provideSavedNewsUseCase(newsRepository: NewsRepository):SaveNewsUseCase{
        return SaveNewsUseCase(newsRepository)

    }

    @Provides
    @Singleton
    fun provideGetSavedNewsUseCase(newsRepository: NewsRepository):GetSavedNewsUseCase{
        return GetSavedNewsUseCase(newsRepository)

    }
    @Provides
    @Singleton
    fun provideDeleteSavedNewsUseCase(newsRepository: NewsRepository):DeleteSavedNewsUseCase{
        return DeleteSavedNewsUseCase(newsRepository)

    }
}