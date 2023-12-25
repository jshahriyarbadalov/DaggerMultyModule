package com.shahriyar.thenewsapp.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.shahriyar.thenewsapp.di.Constants.GLOBAL
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


@Module
class GlobalNavigationModule {

    private val mCicerone: Cicerone<Router> = Cicerone.create()


    @Singleton
    @Provides
    @Named(GLOBAL)
    fun provideRouter(): Router {
        return mCicerone.router
    }

    @Singleton
    @Provides
    @Named(GLOBAL)
    fun provideNavigatorHolder(): NavigatorHolder {
        return mCicerone.getNavigatorHolder()
    }
}