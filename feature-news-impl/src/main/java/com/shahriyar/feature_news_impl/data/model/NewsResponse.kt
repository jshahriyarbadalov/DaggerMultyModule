package com.shahriyar.feature_news_impl.data.model


data class NewsResponse(
    val status: String? = null,
    val totalResults: Int? = null,
    val articles: List<Article>? = null,
)
