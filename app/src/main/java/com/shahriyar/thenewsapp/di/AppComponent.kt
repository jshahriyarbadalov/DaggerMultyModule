package com.shahriyar.thenewsapp.di

import com.shahriyar.thenewsapp.MainActivity
import dagger.Component
import dagger.internal.Preconditions
import javax.inject.Singleton


@Component(modules = [AppModule::class, GlobalNavigationModule::class])
@Singleton
abstract class AppComponent {

    abstract fun inject(activity: MainActivity)

    companion object {
        private var instance: AppComponent? = null

        fun init(component: AppComponent) {
            require(instance == null) { "AppComponent is already initialized." }
            instance = component
        }

        fun get(): AppComponent {
            return Preconditions.checkNotNull(
                instance,
                "AppComponent is not initialized yet. Call init first."
            )!!
        }
    }
}