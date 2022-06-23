package com.example.newsappwithmvvm.data.model


import androidx.room.Entity
import com.google.gson.annotations.SerializedName


data class Source(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)