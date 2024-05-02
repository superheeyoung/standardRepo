package com.standard.multiviewtyperecyclerview.network

import com.standard.multiviewtyperecyclerview.data.remote.remote.SearchRemoteDataSource
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//RetofitClient 객체를 매번 생성하면 high cost -> 싱글톤으로 생성
object RetrofitClient {

    private const val BASE_URL = "https://api.github.com/"

    //네트워크 요청을 위한 httpClient 구성
    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .build()
    }


    //retrofit 객체 초기화 및 생성
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //Retrofit
    val searchGitHubUser : SearchRemoteDataSource by lazy {
        retrofit.create(SearchRemoteDataSource::class.java)
    }
}