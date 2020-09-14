package com.example.lbapplication.network

import com.example.lbapplication.model.CommitResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubSearchCommitApi {

    @Headers( "Accept: application/vnd.github.cloak-preview" )
    @GET("/repos/{owner}/{repo}/commits")
    fun getGithubSearchCommitResponse(
        @Path("owner") owner : String,
        @Path("repo") repo : String
    ): Observable<List<CommitResponse>>
}