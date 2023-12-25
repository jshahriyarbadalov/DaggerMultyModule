package com.shahriyar.feature_news_impl.di

import com.shahriyar.core_network_api.remote.HttpClient


interface NewsDependencies {
    fun client():HttpClient
}