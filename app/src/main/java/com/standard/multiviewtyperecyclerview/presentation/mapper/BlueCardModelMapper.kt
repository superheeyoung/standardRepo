package com.standard.multiviewtyperecyclerview.presentation.mapper

import com.standard.multiviewtyperecyclerview.data.entity.BlueCardEntity
import com.standard.multiviewtyperecyclerview.presentation.model.BlueCardModel

fun List<BlueCardEntity>.asBlueCardModel(): List<BlueCardModel> {
    return map {
        BlueCardModel(
            it.userName,
            it.cardNumber,
            it.cardType,
            it.period,
            it.balance,
            it.cardManager,
            it.cardViewType
        )
    }
}