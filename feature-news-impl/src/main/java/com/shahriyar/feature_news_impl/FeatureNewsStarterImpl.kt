package com.shahriyar.feature_news_impl

import android.content.Context
import android.content.Intent
import com.shahriyar.feature_news_api.FeatureNewsStarter
import com.shahriyar.feature_news_impl.presentation.NewsActivity
import javax.inject.Inject

class FeatureNewsStarterImpl @Inject constructor() :FeatureNewsStarter {
    override fun start(context: Context) {
        val intent = Intent(context, NewsActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}