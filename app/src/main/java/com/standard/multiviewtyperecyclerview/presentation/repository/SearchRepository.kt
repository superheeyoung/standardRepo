package com.standard.multiviewtyperecyclerview.presentation.repository

import com.standard.multiviewtyperecyclerview.presentation.model.BlueCardModel

interface SearchRepository {
    fun getCardList() : List<BlueCardModel>
}