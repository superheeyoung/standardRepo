package com.standard.multiviewtyperecyclerview.presentation.search.repository

import com.standard.multiviewtyperecyclerview.data.database.entity.FavoriteUserEntity


interface CacheRepository {
    suspend fun insertGitHubUserList(favoriteUserEntity: FavoriteUserEntity)
}