package com.standard.multiviewtyperecyclerview.data.database.cache

import com.standard.multiviewtyperecyclerview.data.repository.UserCacheRepositoryImpl
import com.standard.multiviewtyperecyclerview.presentation.search.repository.CacheRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface CacheModule {
    @Binds
    fun bindsUserCacheDataSource(userCacheRepositoryImpl: UserCacheRepositoryImpl) : CacheRepository
}