package com.standard.multiviewtyperecyclerview.data.database

import com.standard.multiviewtyperecyclerview.data.entity.BlueCardEntity

object DataSource {
    fun getCardList(): List<BlueCardEntity> {
        return cardList()
    }
}