package com.example.newsappwithmvvm.presentation.di

import com.example.newsappwithmvvm.data.db.ArticleDAO
import com.example.newsappwithmvvm.data.repository.dataSource.NewsLocalDataSource
import com.example.newsappwithmvvm.data.repository.dataSourceImpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {
      @Singleton
      @Provides
      fun provideLocalDataSource(articleDAO: ArticleDAO):NewsLocalDataSource{
          return NewsLocalDataSourceImpl(articleDAO)
      }
}