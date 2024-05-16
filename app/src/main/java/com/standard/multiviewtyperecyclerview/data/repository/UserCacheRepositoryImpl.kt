package com.standard.multiviewtyperecyclerview.data.repository

import com.standard.multiviewtyperecyclerview.data.database.FavoriteDao
import com.standard.multiviewtyperecyclerview.data.database.entity.FavoriteUserEntity
import com.standard.multiviewtyperecyclerview.presentation.search.repository.CacheRepository
import javax.inject.Inject

class UserCacheRepositoryImpl @Inject constructor(
    private val favoriteDao: FavoriteDao
) : CacheRepository {
    override suspend fun insertGitHubUserList(favoriteUserEntity: FavoriteUserEntity) {
        return favoriteDao.insertFavoriteUser(favoriteUserEntity)
    }
}