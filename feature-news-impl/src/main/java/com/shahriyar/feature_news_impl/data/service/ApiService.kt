package com.shahriyar.feature_news_impl.data.service

import com.shahriyar.core_network_api.remote.HttpClient
import javax.inject.Inject

class ApiService @Inject constructor(
    private val httpClient: HttpClient
) {
    fun callService(): NewsService {
        return httpClient.startRetrofit().create(NewsService::class.java)
    }
}