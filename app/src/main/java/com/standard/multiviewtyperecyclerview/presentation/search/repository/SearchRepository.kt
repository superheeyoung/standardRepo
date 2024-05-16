package com.standard.multiviewtyperecyclerview.presentation.search.repository

import com.standard.multiviewtyperecyclerview.presentation.search.model.GitHubUserList


interface SearchRepository {
    suspend fun getGitHubUserList(userName : String) : GitHubUserList
}