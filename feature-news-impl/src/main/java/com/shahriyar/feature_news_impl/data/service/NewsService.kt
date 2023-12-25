package com.shahriyar.feature_news_impl.data.service

import com.shahriyar.feature_news_impl.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("everything")
    suspend fun getEverything(
        @Query("q") q: String,
        @Query("apiKey") apiKey: String,
    ): NewsResponse
}