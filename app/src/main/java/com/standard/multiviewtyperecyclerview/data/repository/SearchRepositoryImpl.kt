package com.standard.multiviewtyperecyclerview.data.repository


import com.standard.multiviewtyperecyclerview.data.remote.remote.SearchRemoteDataSource
import com.standard.multiviewtyperecyclerview.presentation.search.mapper.toEntity
import com.standard.multiviewtyperecyclerview.presentation.search.repository.SearchRepository
import javax.inject.Inject
class SearchRepositoryImpl @Inject constructor(
    private val remoteDataSource: SearchRemoteDataSource,
) : SearchRepository {
    override suspend fun getGitHubUserList(userName: String) =
        remoteDataSource.getGitHubUser(userName).toEntity()
}