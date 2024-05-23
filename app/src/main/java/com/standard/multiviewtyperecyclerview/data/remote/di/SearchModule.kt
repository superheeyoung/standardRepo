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
    @Binds
    fun bindsSearchRepository(searchRepositoryImpl: SearchRepositoryImpl) : SearchRepository
}