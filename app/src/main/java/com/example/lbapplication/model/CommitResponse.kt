package com.example.lbapplication.model;

data class CommitResponse (
	val sha : String,
	val commit : Commit,
	val author : Author
)