package com.standard.multiviewtyperecyclerview.presentation.search.repository

import com.standard.multiviewtyperecyclerview.presentation.main.model.BlueCardModel
import com.standard.multiviewtyperecyclerview.presentation.search.model.GitHubUserListEntity

interface SearchRepository {
    fun getCardList() : List<BlueCardModel>
    suspend fun getGitHubUserList(userName : String) : GitHubUserListEntity
}