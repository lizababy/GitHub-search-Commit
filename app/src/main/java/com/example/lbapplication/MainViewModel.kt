package com.example.lbapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.lbapplication.model.CommitResponse
import com.example.lbapplication.network.GitHubSearchCommitApi
import com.example.lbapplication.utils.OWNER
import com.example.lbapplication.utils.REPO
import com.example.lbapplication.view.CommitListAdapter
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
        subscription = gitHubSearchCommitApi.getGithubSearchCommitResponse(OWNER, REPO)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::onSuccess, this::onError)
    }

    private fun onSuccess(commitList: List<CommitResponse>) {
        val commitItemViewModels : MutableList<CommitItemViewModel> =
            commitList.mapIndexed { index, commitResponse ->
                CommitItemViewModel(commitResponse.author.login, "Commit #${index+1}: ${commitResponse.sha}", commitResponse.commit.message) }.toMutableList()
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