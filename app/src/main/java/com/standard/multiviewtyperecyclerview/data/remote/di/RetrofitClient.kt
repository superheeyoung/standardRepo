package com.standard.multiviewtyperecyclerview.data.remote.di

import com.standard.multiviewtyperecyclerview.data.remote.remote.SearchRemoteDataSource
import com.standard.multiviewtyperecyclerview.data.remote.retrofit.HttpRequestInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val BASE_URL = "https://api.github.com/"
@Module
@InstallIn(SingletonComponent::class)
internal object RetrofitClient {
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient
            .Builder()
            .addInterceptor(HttpRequestInterceptor())
            .addNetworkInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideSearchRemoteDataSource(retrofit: Retrofit): SearchRemoteDataSource {
        return retrofit.create(SearchRemoteDataSource::class.java)
    }
}