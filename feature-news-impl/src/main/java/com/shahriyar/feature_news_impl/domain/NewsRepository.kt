package com.shahriyar.feature_news_impl.domain

import com.shahriyar.feature_news_impl.data.model.NewsRequest
import com.shahriyar.feature_news_impl.data.model.NewsResponse

interface NewsRepository {
   suspend fun getNewsEverything(req: NewsRequest): NewsResponse
}

