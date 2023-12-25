package com.shahriyar.feature_news_impl.domain

import com.shahriyar.core_network_impl.data.Constants.API_KEY
import com.shahriyar.feature_news_impl.data.model.NewsRequest
import com.shahriyar.feature_news_impl.data.model.NewsResponse
import javax.inject.Inject

class NewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {

    suspend fun loadArticles(keyword: String): NewsResponse{
       return newsRepository.getNewsEverything(NewsRequest(API_KEY, keyword))
    }
}