package com.standard.multiviewtyperecyclerview.data.database

import com.standard.multiviewtyperecyclerview.data.model.BlueCardEntity

object DataSource {
    fun getCardList(): List<BlueCardEntity> {
        return cardList()
    }
}