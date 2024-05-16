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
//Module : external library를 바인딩 정보를 제공할 때 사용
//@InstallIn(SingletonComponent::class) -> object 클래스가 힐트에 사용될지 알려주기 위해 힐트모듈 사용
@Module
@InstallIn(SingletonComponent::class)
internal object RetrofitClient {
    //@Provides : room, retrofit과 같은 외부 라이브러리에서 제공되는 클래스여서 프로젝트 내에서 소유할 수 없는 경우 or builder 패턴을 통해 인스턴스를 생성해야 하는 경우
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