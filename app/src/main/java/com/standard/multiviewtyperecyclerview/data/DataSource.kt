package com.standard.flowerrecyclerview.data

import com.standard.multiviewtyperecyclerview.data.Card

class DataSource {
    companion object {
        private var INSTANCE: DataSource? = null
        fun getDataSource(): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource()
                INSTANCE = newInstance
                newInstance
            }
        }
    }

    fun getCardList(): List<Card> {
        return cardList()
    }

}