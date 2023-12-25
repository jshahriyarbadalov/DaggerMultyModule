package com.shahriyar.thenewsapp

import android.app.Application
import android.content.Context
import com.shahriyar.thenewsapp.di.AppComponent
import com.shahriyar.thenewsapp.di.DaggerAppComponent


class App : Application() {
    companion object {
        @Volatile
        lateinit var appContext: Context
            private set
    }

    fun getAppComponent() = AppComponent.get()

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        AppComponent.init(
            DaggerAppComponent.builder()
                .build()
        )


    }
}