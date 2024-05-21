package com.standard.multiviewtyperecyclerview.data.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.standard.multiviewtyperecyclerview.data.remote.model.GitHubUserResponse

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(boards:List<GitHubUserResponse>)

    @Query("DELETE FROM gitHubUserResponse")
    fun deleteAll()

    @Query("SELECT * FROM gitHubUserResponse ORDER BY id DESC")
    fun getAll(): PagingSource<Int, GitHubUserResponse>
}