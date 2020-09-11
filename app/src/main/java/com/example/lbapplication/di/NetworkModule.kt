package com.example.lbapplication.di

import com.example.lbapplication.network.GitHubSearchCommitApi
import com.example.lbapplication.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
object NetworkModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideGitHubSearchCommitApi(retrofit: Retrofit): GitHubSearchCommitApi {
        return retrofit.create(GitHubSearchCommitApi::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }
}