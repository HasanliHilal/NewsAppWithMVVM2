package com.example.newsappwithmvvm.data.repository.dataSourceImpl

import com.example.newsappwithmvvm.data.db.ArticleDAO
import com.example.newsappwithmvvm.data.model.Article
import com.example.newsappwithmvvm.data.repository.dataSource.NewsLocalDataSource

class NewsLocalDataSourceImpl(
    private val articleDAO: ArticleDAO
) : NewsLocalDataSource {

    override suspend fun saveArticleToDB(article: Article) {
        articleDAO.insert(article)
    }
}