package com.anushka.newsapiclient.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsappwithmvvm.domain.usecase.GetNewsHeadlinesUseCase
import com.example.newsappwithmvvm.domain.usecase.GetSearchedNewsUseCase
import com.example.newsappwithmvvm.domain.usecase.SaveNewsUseCase
import com.example.newsappwithmvvm.presentation.viewmodel.NewsViewModel

class NewsViewModelFactory(
    private val app:Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
            app,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase
        ) as T
    }
}









