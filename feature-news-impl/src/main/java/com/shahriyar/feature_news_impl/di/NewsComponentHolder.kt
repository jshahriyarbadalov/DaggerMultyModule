package com.shahriyar.feature_news_impl.di

import com.shahriyar.core_network_api.remote.HttpClient
import com.shahriyar.core_network_impl.data.HttpClientImpl
import com.shahriyar.feature_news_api.FeatureNewsApi

object NewsComponentHolder {
    private var newsComponent: NewsComponent? = null

    fun initComponent() {
        if (newsComponent == null) {
            newsComponent = NewsComponent.initAndGet(object : NewsDependencies{
                override fun client(): HttpClient {
                   return HttpClientImpl()
                }

            })
        }
    }

    fun get(): FeatureNewsApi {
        checkNotNull(newsComponent) { "was not initialized!" }
        return newsComponent!!
    }

    fun resetComponent() {
        newsComponent = null
    }

    internal fun getComponent() = newsComponent!!
}