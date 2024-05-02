package com.standard.multiviewtyperecyclerview.presentation.search.model

data class GitHubUserListEntity(val items: List<GitHubUserEntity>)
data class GitHubUserEntity(val avatarUrl: String, val loginName: String)