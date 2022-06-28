package com.example.newsappwithmvvm.presentation.di

import android.app.Application
import com.anushka.newsapiclient.presentation.viewmodel.NewsViewModelFactory
import com.example.newsappwithmvvm.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Provides
    @Singleton
    fun provideNewsViewModel(
        app: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
        getSearchedNewsUseCase: GetSearchedNewsUseCase,
        saveNewsUseCase: SaveNewsUseCase,
        getSavedNewsUseCase: GetSavedNewsUseCase,
        deleteSavedNewsUseCase: DeleteSavedNewsUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(app, getNewsHeadlinesUseCase,getSearchedNewsUseCase,saveNewsUseCase,getSavedNewsUseCase, deleteSavedNewsUseCase)
    }

}