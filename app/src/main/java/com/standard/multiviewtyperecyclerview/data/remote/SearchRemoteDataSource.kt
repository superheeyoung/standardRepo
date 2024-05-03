package com.standard.multiviewtyperecyclerview.data.remote

import com.standard.multiviewtyperecyclerview.data.remote.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SearchRemoteDataSource {
    //TODO kakao api key header에 세팅
    @Headers("Authorization: ")
    @GET("v2/search/image")
    suspend fun getSearch(@Query("query") query:String): SearchResponse
}