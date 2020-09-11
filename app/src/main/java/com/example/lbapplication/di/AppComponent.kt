package com.example.lbapplication.di

import com.example.lbapplication.MainActivity
import com.example.lbapplication.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface AppComponent {

    fun inject(mainViewModel: MainViewModel)
    //fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        fun networkModule(networkModule: NetworkModule): Builder
    }
}