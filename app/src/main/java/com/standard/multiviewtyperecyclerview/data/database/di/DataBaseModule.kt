package com.standard.multiviewtyperecyclerview.data.database.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.standard.multiviewtyperecyclerview.data.database.FavoriteDao
import com.standard.multiviewtyperecyclerview.data.database.FavoriteUserDataBase
import com.standard.multiviewtyperecyclerview.data.database.RemoteKeyDao
import com.standard.multiviewtyperecyclerview.data.database.UserDao
import com.standard.multiviewtyperecyclerview.data.database.entity.RemoteKey
import com.standard.multiviewtyperecyclerview.data.remote.model.GitHubUserResponse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataBaseModule {
    @Provides
    fun provideFavoriteUserDataBase(application: Application) : FavoriteUserDataBase {
        return Room.databaseBuilder(
            application,
            FavoriteUserDataBase::class.java,
            "FavoriteUserDataBase"
        )
            .build()
    }

    @Provides
    fun ProvidesFavoriteDao(appDatabase : FavoriteUserDataBase) : FavoriteDao {
        return appDatabase.favortieDao()
    }

    @Provides
    fun ProvidesUserDao(appDatabase: FavoriteUserDataBase) : UserDao {
        return appDatabase.userDao()
    }

    @Provides
    fun ProvidesRemoteKeyDao(appDatabase: FavoriteUserDataBase) : RemoteKeyDao {
        return appDatabase.remoteKeyDao()
    }

}