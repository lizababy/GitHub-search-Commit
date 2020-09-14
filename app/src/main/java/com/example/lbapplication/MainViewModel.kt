package com.example.lbapplication

import android.util.Log
import com.example.lbapplication.model.CommitResponse
import com.example.lbapplication.network.GitHubSearchCommitApi
import javax.inject.Inject

class MainViewModel @Inject constructor(private var gitHubSearchCommitApi: GitHubSearchCommitApi) {
    init {
        Log.d("*****message","init")

        gitHubSearchCommitApi.getGithubSearchCommitResponse().subscribe(this::onSuccess,this::onError)
    }

    private fun onSuccess(response: List<CommitResponse>) {
        Log.d("*****message","success" + response[0].commit.message)
    }

    private fun onError(error:Throwable){
        Log.d("*****message", "error" + error.localizedMessage)

    }
}