package com.vk.chillify.di

import android.content.Context
import com.vk.chillify.MainActivity
import com.vk.chillify.di.module.DataModule
import com.vk.chillify.di.module.DomainModule
import com.vk.chillify.di.module.PresentationModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DataModule::class,
        DomainModule::class,
        PresentationModule::class,
    ]
)
interface AppComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface AppComponentFactory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}