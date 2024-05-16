package com.standard.multiviewtyperecyclerview.data.remote.model

import com.google.gson.annotations.SerializedName

data class GitHubUserListResponse(
    @SerializedName("items") val items: List<GitHubUserResponse>
)

data class GitHubUserResponse(
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("login") val loginName: String,
    @SerializedName("id") val id : Int
)