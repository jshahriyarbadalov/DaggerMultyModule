package com.shahriyar.feature_news_impl.di

import com.shahriyar.feature_news_api.FeatureNewsApi
import com.shahriyar.feature_news_api.FeatureNewsStarter
import com.shahriyar.feature_news_impl.presentation.NewsActivity
import dagger.Component

@Component(modules = [NewsModule::class], dependencies = [NewsDependencies::class])
interface NewsComponent : FeatureNewsApi{
    fun inject(activity: NewsActivity)

    companion object {
        fun initAndGet(newsDependencies: NewsDependencies): NewsComponent {
            return DaggerNewsComponent.builder().newsDependencies(newsDependencies).build()
        }
    }

}