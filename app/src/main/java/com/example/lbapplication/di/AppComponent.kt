package com.example.lbapplication

import dagger.Component

@Component
interface AppComponent {

    fun inject(activity: MainActivity)
}