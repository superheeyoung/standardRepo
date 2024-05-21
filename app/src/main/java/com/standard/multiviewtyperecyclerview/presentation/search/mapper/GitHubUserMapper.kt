package com.standard.multiviewtyperecyclerview.presentation.search.mapper

import com.standard.multiviewtyperecyclerview.data.remote.model.GitHubUserListResponse
import com.standard.multiviewtyperecyclerview.data.remote.model.GitHubUserResponse
import com.standard.multiviewtyperecyclerview.presentation.search.model.GitHubUser
import com.standard.multiviewtyperecyclerview.presentation.search.model.GitHubUserList

fun GitHubUserListResponse.toEntity() = GitHubUserList(
    items = items.asGitHubUserEntity()
)

fun List<GitHubUserResponse>.asGitHubUserEntity(): List<GitHubUser> {
    return map {
        GitHubUser(
            it.avatarUrl,
            it.loginName,
            it.id
        )
    }
}

fun GitHubUserResponse.asGitHubUser() : GitHubUser{
    return GitHubUser(
        avatarUrl,
        loginName,
        id
    )
}