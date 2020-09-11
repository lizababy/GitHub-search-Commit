package com.example.lbapplication

import androidx.lifecycle.ViewModel
import com.example.lbapplication.di.DaggerAppComponent
import com.example.lbapplication.di.NetworkModule
import com.example.lbapplication.network.GitHubSearchCommitApi
import javax.inject.Inject

class MainViewModel : ViewModel() {

    @Inject
    lateinit var gitHubSearchCommitApi: GitHubSearchCommitApi

    init {
        DaggerAppComponent
            .builder()
            .networkModule(NetworkModule)
            .build().inject(this)
    }
}