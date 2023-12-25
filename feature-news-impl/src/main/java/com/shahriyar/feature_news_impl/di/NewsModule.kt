package com.shahriyar.feature_news_impl.di

import androidx.lifecycle.ViewModel
import com.shahriyar.feature_news_api.FeatureNewsStarter
import com.shahriyar.feature_news_impl.FeatureNewsStarterImpl
import com.shahriyar.feature_news_impl.data.repository.NewsRepositoryImpl
import com.shahriyar.feature_news_impl.domain.NewsRepository
import com.shahriyar.feature_news_impl.domain.NewsUseCase
import com.shahriyar.feature_news_impl.presentation.NewsViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class NewsModule {

    @Binds
    abstract fun bindFeatureStarter(featureNewsStarterImpl: FeatureNewsStarterImpl): FeatureNewsStarter

    @Binds
    abstract fun bindFeatureNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository

    @Binds
    abstract fun bindNewsViewModel(newsViewModel: NewsViewModel): ViewModel
}