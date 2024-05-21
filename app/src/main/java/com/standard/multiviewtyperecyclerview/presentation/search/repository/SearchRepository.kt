package com.standard.multiviewtyperecyclerview.presentation.search.repository

import androidx.paging.PagingData
import com.standard.multiviewtyperecyclerview.presentation.search.model.GitHubUser
import com.standard.multiviewtyperecyclerview.presentation.search.model.GitHubUserList
import kotlinx.coroutines.flow.Flow


interface SearchRepository {
    suspend fun getGitHubUserList(userName : String) : GitHubUserList
    suspend fun getPagingGitHubUserList(userName : String) : Flow<PagingData<GitHubUser>>

    suspend fun getGitHubUserLists(userName : String) : Flow<PagingData<GitHubUser>>
}