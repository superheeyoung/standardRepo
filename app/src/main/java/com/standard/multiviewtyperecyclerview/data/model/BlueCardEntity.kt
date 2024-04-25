package com.standard.multiviewtyperecyclerview.data.model

import com.standard.multiviewtyperecyclerview.presentation.main.MultiViewEnum

//@Parcelize 키워드 사용 시 build gradle 추가

data class BlueCardEntity(
    val userName: String,
    val cardNumber: String,
    val cardType: String,
    val period: String,
    val balance: Double,
    val cardManager: String,
    val cardViewType : MultiViewEnum
)
