package com.standard.multiviewtyperecyclerview.data.remote.model

import com.google.gson.annotations.SerializedName

data class GitHubUserListResponse(
    /*
    * 서버에서 받은 데이터를 data class에 담는 역직렬화 과정에서 필드 이름 매핑을 명시적으로 제공하기 위해 사용
      Gson 라이브러리에 포함돼 있음 -> moshi사용시 다르게 사용해야 함
      JSON 안에서 어노테이션에 지정된 이름과 일치하는 key의 value를 찾은 다음, 그 value를 변수의 타입에 맞게 자동으로 변환해서 변수에 할당
    * */
    @SerializedName("items") val items: List<GitHubUserResponse>
)

data class GitHubUserResponse(
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("login") val loginName: String,
    @SerializedName("id") val id : Int
)