package com.standard.multiviewtyperecyclerview.data.database.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.standard.multiviewtyperecyclerview.data.database.FavoriteDao
import com.standard.multiviewtyperecyclerview.data.database.FavoriteUserDataBase
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
}