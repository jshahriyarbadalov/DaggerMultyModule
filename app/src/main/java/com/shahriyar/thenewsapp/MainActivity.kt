package com.shahriyar.thenewsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.shahriyar.thenewsapp.databinding.ActivityMainBinding
import com.shahriyar.thenewsapp.di.Constants.GLOBAL
import com.shahriyar.thenewsapp.routing.GlobalNavigation
import com.shahriyar.thenewsapp.routing.GlobalScreenNames
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @Inject
    @Named(GLOBAL)
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    @Named(GLOBAL)
    lateinit var router: Router

    @Inject
    lateinit var globalNavigator: GlobalNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (applicationContext as App).getAppComponent().inject(this)

        navigatorHolder.setNavigator(globalNavigator)

        binding.btnEnter.setOnClickListener {
            router.navigateTo(GlobalScreenNames.NewsFeatureScreen)
        }
    }
}