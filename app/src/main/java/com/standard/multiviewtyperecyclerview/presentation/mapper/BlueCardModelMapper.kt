package com.standard.multiviewtyperecyclerview.presentation.mapper

import com.standard.multiviewtyperecyclerview.data.entity.BlueCardEntity
import com.standard.multiviewtyperecyclerview.presentation.model.BlueCardModel

//위치는 자율
//추후 DTO, DAO, Entity등 domain layer, presentation layer에 필요한 model만 data class에서 mapping해서 쓸 용도
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