package com.standard.multiviewtyperecyclerview.data.repository


import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.standard.multiviewtyperecyclerview.data.remote.remote.SearchPagingRemoteDataSource
import com.standard.multiviewtyperecyclerview.data.remote.remote.SearchRemoteDataSource
import com.standard.multiviewtyperecyclerview.presentation.search.mapper.asGitHubUser
import com.standard.multiviewtyperecyclerview.presentation.search.mapper.toEntity
import com.standard.multiviewtyperecyclerview.presentation.search.model.GitHubUser
import com.standard.multiviewtyperecyclerview.presentation.search.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val remoteDataSource: SearchRemoteDataSource
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
}