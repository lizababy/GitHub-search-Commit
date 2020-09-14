package com.example.lbapplication

import androidx.lifecycle.ViewModel

class CommitItemViewModel(
    val author: String,
    val sha: String,
    val message: String
): ViewModel()