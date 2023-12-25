package com.shahriyar.core_network_impl.di

import com.shahriyar.core_network_api.remote.CoreNetworkApi
import dagger.Component


@Component(modules = [NetworkModule::class])
interface CoreNetworkComponent: CoreNetworkApi {
    companion object {
        private var coreNetworkComponent: CoreNetworkComponent? = null

        fun get(): CoreNetworkComponent? {
            if (coreNetworkComponent == null) {
                synchronized(CoreNetworkComponent::class.java) {
                    if (coreNetworkComponent == null) {
                        coreNetworkComponent = DaggerCoreNetworkComponent.builder().build()
                    }
                }
            }
            return coreNetworkComponent
        }
    }

}