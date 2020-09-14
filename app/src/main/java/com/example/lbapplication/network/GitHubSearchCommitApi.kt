package com.example.lbapplication.network

import com.example.lbapplication.model.CommitResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers

interface GitHubSearchCommitApi {

    @Headers( "Accept: application/vnd.github.cloak-preview" )
    @GET("/repos/lizababy/GitHub-search-Commit/commits")
    fun getGithubSearchCommitResponse(): Observable<List<CommitResponse>>
}