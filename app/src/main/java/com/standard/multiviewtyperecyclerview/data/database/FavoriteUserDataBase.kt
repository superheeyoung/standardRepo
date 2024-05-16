package com.standard.multiviewtyperecyclerview.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.standard.multiviewtyperecyclerview.data.database.entity.FavoriteUserEntity

@Database(
    entities = [
        FavoriteUserEntity::class
    ],
    version = 1
)

abstract class FavoriteUserDataBase : RoomDatabase() {
    abstract fun favortieDao() : FavoriteDao
}
