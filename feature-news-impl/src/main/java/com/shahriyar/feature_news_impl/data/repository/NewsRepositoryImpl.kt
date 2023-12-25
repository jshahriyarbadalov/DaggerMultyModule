package com.shahriyar.feature_news_impl.data.repository

import com.shahriyar.feature_news_impl.data.service.ApiService
import com.shahriyar.feature_news_impl.data.model.NewsRequest
import com.shahriyar.feature_news_impl.data.model.NewsResponse
import com.shahriyar.feature_news_impl.domain.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : NewsRepository {

    override suspend fun getNewsEverything(req: NewsRequest): NewsResponse {
       return apiService.callService().getEverything(req.q.orEmpty(), req.apiKey.orEmpty())
    }
}