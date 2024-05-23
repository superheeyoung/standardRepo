package com.standard.multiviewtyperecyclerview.presentation.search.mapper

import com.standard.multiviewtyperecyclerview.data.remote.model.GitHubUserListResponse
import com.standard.multiviewtyperecyclerview.data.remote.model.GitHubUserResponse
import com.standard.multiviewtyperecyclerview.presentation.search.model.GitHubUser
import com.standard.multiviewtyperecyclerview.presentation.search.model.GitHubUserList
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNull.content

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

fun GitHubUserResponse.asGitHubUser() : GitHubUser {
   // val contentParam = Json.decodeFromString<ContentParam>(content)
    return GitHubUser(
        this.avatarUrl,
        this.loginName,
        this.id
    )
}
