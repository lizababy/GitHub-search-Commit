package com.example.lbapplication.network

import com.example.lbapplication.model.GithubSearchCommitResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface GitHubSearchCommitApi {

    @GET("/search/commits")
    fun getGithubSearchCommitResponse(): Observable<GithubSearchCommitResponse>
}