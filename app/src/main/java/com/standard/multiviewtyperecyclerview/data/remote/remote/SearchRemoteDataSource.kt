package com.standard.multiviewtyperecyclerview.data.remote.remote

import com.standard.multiviewtyperecyclerview.data.remote.model.GitHubUserListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchRemoteDataSource {
    @GET("/search/users")
    suspend fun getGitHubUser(
        @Query("q") name: String,
        @Query("page") page: Int = 0,
        @Query("per_page") perPage: Int = 0
    ) : GitHubUserListResponse

}