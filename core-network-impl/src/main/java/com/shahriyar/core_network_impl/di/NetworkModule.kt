package com.shahriyar.core_network_impl.di

import com.shahriyar.core_network_api.remote.HttpClient
import com.shahriyar.core_network_impl.data.HttpClientImpl
import dagger.Binds
import dagger.Module

@Module
abstract class NetworkModule {
    @Binds
    abstract fun bindsHttpClient(httpClientImpl: HttpClientImpl): HttpClient
}