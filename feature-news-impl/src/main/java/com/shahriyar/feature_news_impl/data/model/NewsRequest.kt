package com.shahriyar.feature_news_impl.data.model

import java.io.Serializable

data class NewsRequest(
    val apiKey: String? = null,
    val q: String? = null,
) : Serializable