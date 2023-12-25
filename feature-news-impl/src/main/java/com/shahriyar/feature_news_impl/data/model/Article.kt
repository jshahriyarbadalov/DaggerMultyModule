package com.shahriyar.feature_news_impl.data.model

import java.io.Serializable


data class Article(
    val source: NewsSourceModel? = null,
    val author: String? = null,
    val title: String? = null,
    val description: String? = null,
    val url: String? = null,
    val urlToImage: String? = null,
    val publishedAt: String? = null,
    val content: String? = null,
) : Serializable


data class NewsSourceModel(
    val id: String? = null,
    val name: String? = null,
) : Serializable