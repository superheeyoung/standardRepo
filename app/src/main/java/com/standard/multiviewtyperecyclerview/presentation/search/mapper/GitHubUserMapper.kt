package com.standard.multiviewtyperecyclerview.presentation.search.mapper

import com.standard.multiviewtyperecyclerview.data.remote.model.GitHubUserListResponse
import com.standard.multiviewtyperecyclerview.data.remote.model.GitHubUserResponse
import com.standard.multiviewtyperecyclerview.presentation.search.model.GitHubUserEntity
import com.standard.multiviewtyperecyclerview.presentation.search.model.GitHubUserListEntity

fun GitHubUserListResponse.toEntity() = GitHubUserListEntity(
    items = items.asGitHubUserEntity()
)

fun List<GitHubUserResponse>.asGitHubUserEntity(): List<GitHubUserEntity> {
    return map {
        GitHubUserEntity(
            it.avatarUrl,
            it.loginName,
            it.id
        )
    }
}