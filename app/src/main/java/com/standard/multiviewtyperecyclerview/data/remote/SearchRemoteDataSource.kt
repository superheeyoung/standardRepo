package com.standard.multiviewtyperecyclerview.data.remote

import com.standard.multiviewtyperecyclerview.data.remote.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SearchRemoteDataSource {
    @Headers("Authorization: KakaoAK 087e584018c0f7bfd2c5e694c504335c")
    @GET("v2/search/image")
    suspend fun getSearch(@Query("query") query:String): SearchResponse
}