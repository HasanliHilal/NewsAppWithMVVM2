package com.example.newsappwithmvvm.data.db

import androidx.room.*
import com.example.newsappwithmvvm.data.model.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)
    @Query("Select * from articles")
    fun getAllArticle(): Flow<List<Article>>
    @Delete
    suspend fun deleteArticle(article: Article)
}