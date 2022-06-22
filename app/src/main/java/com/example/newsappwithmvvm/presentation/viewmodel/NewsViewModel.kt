package com.example.newsappwithmvvm.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappwithmvvm.data.model.APIResponse
import com.example.newsappwithmvvm.data.util.Resource
import com.example.newsappwithmvvm.domain.usecase.GetNewsHeadlinesUseCase
import com.example.newsappwithmvvm.domain.usecase.GetSearchedNewsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class NewsViewModel(
    private val app: Application,
    val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    val getSearchedNewsUseCase: GetSearchedNewsUseCase
) : AndroidViewModel(app) {
    val newsHeadLines: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun getNewsHeadLines(country: String, page: Int) = viewModelScope.launch(Dispatchers.IO) {
        newsHeadLines.postValue(Resource.Loading())
        if (isNetworkAvailable(app)) {
            val apiResult = getNewsHeadlinesUseCase.execute(country, page)
            newsHeadLines.postValue(apiResult)
        }
    }

    private fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false

    }

    val seachedNews: MutableLiveData<Resource<APIResponse>> = MutableLiveData()
    fun searchNews(country: String, searchQuery: String, page: Int) = viewModelScope.launch {
        seachedNews.postValue(Resource.Loading())
        try {
            if (isNetworkAvailable(app)) {
                val response = getSearchedNewsUseCase.execute(country, searchQuery, page)
                seachedNews.postValue(response)
            } else {
                seachedNews.postValue(Resource.Error("No Internet connection"))
            }
        } catch (e: Exception) {
            seachedNews.postValue(Resource.Error(e.message.toString()))
        }

    }
}