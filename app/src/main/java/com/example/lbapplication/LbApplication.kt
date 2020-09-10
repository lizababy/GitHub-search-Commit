package com.example.lbapplication

import android.app.Application

class LbApplication : Application() {

    val appComponent : AppComponent by lazy {
        DaggerAppComponent.create()
    }
}