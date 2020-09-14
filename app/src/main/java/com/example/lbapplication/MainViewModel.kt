package com.example.lbapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.lbapplication.model.CommitResponse
import com.example.lbapplication.network.GitHubSearchCommitApi
import com.example.lbapplication.view.CommitListAdapter
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val gitHubSearchCommitApi: GitHubSearchCommitApi,
    val adapter: CommitListAdapter
) :
    ViewModel() {
    private lateinit var subscription: Disposable

    init {
        loadCommits()
    }

    private fun loadCommits() {
        subscription = gitHubSearchCommitApi.getGithubSearchCommitResponse()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::onSuccess, this::onError)
    }

    private fun onSuccess(commitList: List<CommitResponse>) {
        val commitItemViewModels : MutableList<CommitItemViewModel> =
            commitList.map { CommitItemViewModel(it.sha, it.author.login, it.commit.message) }.toMutableList()
        adapter.setData(commitItemViewModels)
    }

    private fun onError(error: Throwable) {
        Log.d("*****message", "error" + error.localizedMessage)
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}