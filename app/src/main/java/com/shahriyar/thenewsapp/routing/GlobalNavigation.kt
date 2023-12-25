package com.shahriyar.thenewsapp.routing

import android.content.Context
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.Screen
import com.shahriyar.feature_news_api.FeatureNewsApi
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class GlobalNavigation  @Inject constructor(
    private val featureLogin: Provider<FeatureNewsApi>,
    private val context: Context
) : Navigator {

    override fun applyCommands(commands: Array<out Command>) {
        for (command in commands) {
            applyCommand(command)
        }
    }

    private fun applyCommand(command: Command) {
        if (command is Forward) {
            forward(command)
            return
        }
        throw RuntimeException("Unexpected action")
    }

    private fun forward(command: Forward) {
        val name = command.screen
        startFeatureStartPoint(name)
    }

    private fun startFeatureStartPoint(screen: Screen) {
        when (screen) {
            GlobalScreenNames.NewsFeatureScreen -> {
                featureLogin.get().newsStarter().start(context)
                return
            }

            else -> throw RuntimeException("Unexpected screen: $screen")
        }
    }
}