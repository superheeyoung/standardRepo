package com.standard.multiviewtyperecyclerview.data.repository

import com.standard.multiviewtyperecyclerview.data.database.DataSource
import com.standard.multiviewtyperecyclerview.presentation.mapper.asBlueCardModel
import com.standard.multiviewtyperecyclerview.presentation.repository.SearchRepository
//model로 mapping하는 위치는 자율
class SearchRepositoryImpl(private val dataSource : DataSource) : SearchRepository{
    override fun getCardList() = dataSource.getCardList().asBlueCardModel()
}