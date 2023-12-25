package com.shahriyar.thenewsapp.di

import android.content.Context
import com.shahriyar.feature_news_api.FeatureNewsApi
import com.shahriyar.feature_news_impl.di.NewsComponentHolder
import com.shahriyar.thenewsapp.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(): Context {
        return App.appContext
    }

    @Singleton
    @Provides
    fun provideNewsFeature(): FeatureNewsApi {
        NewsComponentHolder.initComponent()
        return NewsComponentHolder.get()
    }
}