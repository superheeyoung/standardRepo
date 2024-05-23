package com.standard.multiviewtyperecyclerview.data.remote.remote

import android.net.http.HttpException
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.standard.multiviewtyperecyclerview.data.database.FavoriteUserDataBase
import com.standard.multiviewtyperecyclerview.data.database.entity.RemoteKey
import com.standard.multiviewtyperecyclerview.data.remote.model.GitHubUserResponse
import java.io.IOException
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class SearchRemoteMediator @Inject constructor(
    private val database: FavoriteUserDataBase,
    private val searchRemoteDataSource: SearchRemoteDataSource
) : RemoteMediator<Int, GitHubUserResponse>() {
    val remoteKeyDao = database.remoteKeyDao()
    val userDao = database.userDao()

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, GitHubUserResponse>
    ): MediatorResult {
        val remoteKey = when (loadType) {
            //새로고침
            LoadType.REFRESH -> {
                null
            }

            //첫번째 페이지
            LoadType.PREPEND -> {
                return MediatorResult.Success(true)
            }

            //마지막 페이지 이후의 데이터 로드
            LoadType.APPEND -> {
                remoteKeyDao.getNextKey()
            }
        }

        try {
            val page = remoteKey?.nextPage ?: 1 //pagination
            val loadSize = 20
            val response = searchRemoteDataSource.getGitHubUser("cindy", page, loadSize)
            val userList = response.items
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



