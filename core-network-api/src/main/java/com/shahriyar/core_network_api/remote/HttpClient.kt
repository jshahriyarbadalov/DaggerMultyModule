package com.shahriyar.core_network_api.remote

import retrofit2.Retrofit

interface HttpClient {
    fun startRetrofit(): Retrofit
}