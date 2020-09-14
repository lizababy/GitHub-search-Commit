package com.example.lbapplication

import android.app.Application
import com.example.lbapplication.di.AppComponent
import com.example.lbapplication.di.DaggerAppComponent

class LbApplication : Application() {

    val appComponent : AppComponent by lazy {
        DaggerAppComponent.create()
    }
}