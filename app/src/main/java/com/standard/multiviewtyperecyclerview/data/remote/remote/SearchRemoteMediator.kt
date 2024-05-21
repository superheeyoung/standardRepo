package com.standard.multiviewtyperecyclerview.data.remote.remote

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.standard.multiviewtyperecyclerview.data.database.FavoriteUserDataBase
import com.standard.multiviewtyperecyclerview.data.database.entity.RemoteKey
import com.standard.multiviewtyperecyclerview.data.remote.model.GitHubUserResponse
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class SearchRemoteMediator @Inject constructor(
    //private val userName: String,
    private val database: FavoriteUserDataBase,
    private val searchRemoteDataSource: SearchRemoteDataSource
) : RemoteMediator<Int, GitHubUserResponse>() {
    val remoteKeyDao = database.remoteKeyDao()
    val userDao = database.userDao()
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, GitHubUserResponse>
    ): MediatorResult {
        val remoteKey = when (loadType) {
            LoadType.REFRESH -> {
                null
            }

            LoadType.PREPEND -> {
                return MediatorResult.Success(true)
            }

            LoadType.APPEND -> {
                remoteKeyDao.getNextKey()
            }
        }

        try {
            val page = remoteKey?.nextPage ?: 1
            val loadSize = 30
            val response = searchRemoteDataSource.getGitHubUser("cindy", loadSize, page)
            val userList = response.items
            Log.d("debug3444",userList.size.toString())
            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    userDao.deleteAll()
                    remoteKeyDao.deleteAll()
                }
                remoteKeyDao.insert(RemoteKey(nextPage = page + 1))
                userDao.insertAll(userList)
            }
            return MediatorResult.Success(loadSize != userList.size)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }

}
