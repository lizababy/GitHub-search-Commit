package com.example.lbapplication.model;

class GithubSearchCommitResponse (
	val total_count : Int,
	val incomplete_results : Boolean,
	val items : List<Item>
)