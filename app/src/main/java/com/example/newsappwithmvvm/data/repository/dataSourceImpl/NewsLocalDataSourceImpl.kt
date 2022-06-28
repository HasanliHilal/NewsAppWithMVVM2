package com.example.newsappwithmvvm.data.repository.dataSourceImpl

import com.example.newsappwithmvvm.data.db.ArticleDAO
import com.example.newsappwithmvvm.data.model.Article
import com.example.newsappwithmvvm.data.repository.dataSource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(
    private val articleDAO: ArticleDAO
) : NewsLocalDataSource {

    override suspend fun saveArticleToDB(article: Article) {
        articleDAO.insert(article)
    }

    override fun getSavedArticles(): Flow<List<Article>> {
        return  articleDAO.getAllArticle()
    }

    override suspend fun deleteArticleFromDB(article: Article) {
        articleDAO.deleteArticle(article)
    }
}