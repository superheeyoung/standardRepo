package com.standard.multiviewtyperecyclerview.data.remote.repository

import com.standard.multiviewtyperecyclerview.data.database.DataSource
import com.standard.multiviewtyperecyclerview.data.remote.remote.SearchRemoteDataSource
import com.standard.multiviewtyperecyclerview.presentation.main.mapper.asBlueCardModel
import com.standard.multiviewtyperecyclerview.presentation.search.mapper.toEntity
import com.standard.multiviewtyperecyclerview.presentation.search.repository.SearchRepository

//model로 mapping하는 위치는 자율
//repository -> dataSource의 의존성 회피
//의존을 없애면 datasource변경(network->database) 시 repository에 영향 xx

//interface인 repository를 구현함으로써 dataSource의 data를 가져옴
class SearchRepositoryImpl(
    private val dataSource: DataSource,
    private val remoteDataSource: SearchRemoteDataSource
) : SearchRepository {
    override fun getCardList() = dataSource.getCardList().asBlueCardModel()

    override suspend fun getGitHubUserList(userName: String) =
        remoteDataSource.getGitHubUser(userName).toEntity()
}