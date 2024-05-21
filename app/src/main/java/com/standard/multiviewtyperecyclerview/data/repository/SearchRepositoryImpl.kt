package com.standard.multiviewtyperecyclerview.data.repository


import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.standard.multiviewtyperecyclerview.data.database.FavoriteUserDataBase
import com.standard.multiviewtyperecyclerview.data.remote.remote.SearchPagingRemoteDataSource
import com.standard.multiviewtyperecyclerview.data.remote.remote.SearchRemoteDataSource
import com.standard.multiviewtyperecyclerview.data.remote.remote.SearchRemoteMediator
import com.standard.multiviewtyperecyclerview.presentation.search.mapper.asGitHubUser
import com.standard.multiviewtyperecyclerview.presentation.search.mapper.toEntity
import com.standard.multiviewtyperecyclerview.presentation.search.model.GitHubUser
import com.standard.multiviewtyperecyclerview.presentation.search.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val remoteDataSource: SearchRemoteDataSource,
    private val dataBase: FavoriteUserDataBase,
    private val mediator: SearchRemoteMediator
) : SearchRepository {
    override suspend fun getGitHubUserList(userName: String) =
        remoteDataSource.getGitHubUser(userName).toEntity()

    override suspend fun getPagingGitHubUserList(userName: String): Flow<PagingData<GitHubUser>> {
        return Pager(
            config = PagingConfig(
                pageSize = SearchPagingRemoteDataSource.defaultDisplay,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                SearchPagingRemoteDataSource(userName, remoteDataSource)
            }
        ).flow.map { pagingData ->
            pagingData.map {
                it.asGitHubUser()
            }
        }
    }

    @OptIn(ExperimentalPagingApi::class)
    override suspend fun getGitHubUserLists(userName: String): Flow<PagingData<GitHubUser>> =
        Pager(
            config = PagingConfig(
                pageSize = 20
            ),
            remoteMediator = mediator,
            pagingSourceFactory = {
                dataBase.userDao().getAll()
            }
        ).flow.map {
            it.map {
                it.asGitHubUser()
            }
        }
}
