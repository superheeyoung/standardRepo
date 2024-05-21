package com.standard.multiviewtyperecyclerview.data.remote.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class GitHubUserListResponse(
    @SerializedName("items") val items: List<GitHubUserResponse>
)

@Entity
data class GitHubUserResponse(
    @PrimaryKey val uid:Long,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("login") val loginName: String,
    @SerializedName("id") val id : Int
)