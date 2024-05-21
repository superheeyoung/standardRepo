package com.standard.multiviewtyperecyclerview.data.remote.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class GitHubUserListResponse(
    @SerializedName("items") val items: List<GitHubUserResponse>
)

@Entity
@Serializable
data class GitHubUserResponse(
    @PrimaryKey(autoGenerate = true)val uid:Long,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("login") val loginName: String,
    @SerializedName("id") val id : Int
)