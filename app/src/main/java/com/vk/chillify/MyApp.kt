package com.vk.chillify

import android.app.Application
import com.vk.chillify.di.AppComponent
import com.vk.chillify.di.DaggerAppComponent

class MyApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}