package com.standard.multiviewtyperecyclerview.presentation.search.mapper

import com.standard.multiviewtyperecyclerview.data.database.entity.FavoriteUserEntity
import com.standard.multiviewtyperecyclerview.data.remote.model.GitHubUserResponse
import com.standard.multiviewtyperecyclerview.presentation.search.model.GitHubUser

fun GitHubUser.asFavoriteUserEntity(): FavoriteUserEntity {
    return FavoriteUserEntity(
        avatarUrl = avatarUrl,
        loginName = loginName,
        id = id,
        isFavorite = isFavorite
    )
}