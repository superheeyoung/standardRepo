package com.standard.multiviewtyperecyclerview.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.standard.multiviewtyperecyclerview.data.database.entity.FavoriteUserEntity
import com.standard.multiviewtyperecyclerview.data.database.entity.RemoteKey
import com.standard.multiviewtyperecyclerview.data.remote.model.GitHubUserResponse

@Database(
    entities = [
        FavoriteUserEntity::class,
        GitHubUserResponse::class,
        RemoteKey::class
    ],
    version = 1
)
abstract class FavoriteUserDataBase : RoomDatabase() {
    abstract fun favortieDao() : FavoriteDao
    abstract fun remoteKeyDao() : RemoteKeyDao
    abstract fun userDao() : UserDao
}
