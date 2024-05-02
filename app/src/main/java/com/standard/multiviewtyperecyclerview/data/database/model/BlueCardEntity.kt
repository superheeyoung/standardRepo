package com.standard.multiviewtyperecyclerview.data.database.model

import com.standard.multiviewtyperecyclerview.presentation.main.main.MultiViewEnum

//ResponseData, DTO, DAO 등..
data class BlueCardEntity(
    val userName: String,
    val cardNumber: String,
    val cardType: String,
    val period: String,
    val balance: Double,
    val cardManager: String,
    val cardViewType : MultiViewEnum
)
