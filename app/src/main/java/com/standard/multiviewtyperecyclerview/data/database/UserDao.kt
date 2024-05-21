package com.standard.multiviewtyperecyclerview.data.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.standard.multiviewtyperecyclerview.data.remote.model.GitHubUserResponse

@Dao
interface UserDao {
    @Upsert
    fun insertAll(list:List<GitHubUserResponse>)

    @Query("DELETE FROM gitHubUserResponse")
    fun deleteAll()

    @Query("SELECT * FROM gitHubUserResponse")
    fun getAll(): PagingSource<Int, GitHubUserResponse>
}