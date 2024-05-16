package com.standard.multiviewtyperecyclerview.data.remote.di

import com.standard.multiviewtyperecyclerview.data.repository.SearchRepositoryImpl
import com.standard.multiviewtyperecyclerview.presentation.search.repository.SearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface SearchModule {
    //Binds -> constructor를 가질 수 없는 인터페이스에 종속성 삽입할 때
    @Binds
    fun bindsSearchRepository(searchRepositoryImpl: SearchRepositoryImpl) : SearchRepository
}