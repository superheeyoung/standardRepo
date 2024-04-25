package com.standard.multiviewtyperecyclerview.data.database

import com.standard.multiviewtyperecyclerview.data.entity.BlueCardEntity
import com.standard.multiviewtyperecyclerview.presentation.main.MultiViewEnum

//network or cache data로 변경될 예정
fun cardList() : List<BlueCardEntity> {
    return listOf(
        BlueCardEntity(
            "Anderson",
            "2423 3581 9503 2412",
            "A Debit Card",
            "21/27",
            3100.30,
            "Visa",
            MultiViewEnum.BLUE
        ),
        BlueCardEntity(
            "Jimmy",
            "1234 5678 1234 1111",
            "A Prepaid Card",
            "19/25",
            5431.40,
            "Master",
            MultiViewEnum.LIGHTBLUE
        ),
        BlueCardEntity(
            "Hanna",
            "4443 2345 4564 1231",
            "A Credit Card",
            "23/28",
            1030.99,
            "Union",
            MultiViewEnum.ORANGE
        ),
        BlueCardEntity(
            "Anderson",
            "2423 3581 9503 2412",
            "A Debit Card",
            "21/27",
            3100.30,
            "Visa",
            MultiViewEnum.BLUE
        ),
        BlueCardEntity(
            "Jimmy",
            "1234 5678 1234 1111",
            "A Prepaid Card",
            "19/25",
            5431.40,
            "Master",
            MultiViewEnum.LIGHTBLUE
        ),
        BlueCardEntity(
            "Hanna",
            "4443 2345 4564 1231",
            "A Credit Card",
            "23/28",
            1030.99,
            "Union",
            MultiViewEnum.ORANGE
        ),
        BlueCardEntity(
            "Anderson",
            "2423 3581 9503 2412",
            "A Debit Card",
            "21/27",
            3100.30,
            "Visa",
            MultiViewEnum.BLUE
        ),
        BlueCardEntity(
            "Jimmy",
            "1234 5678 1234 1111",
            "A Prepaid Card",
            "19/25",
            5431.40,
            "Master",
            MultiViewEnum.LIGHTBLUE
        ),
        BlueCardEntity(
            "Hanna",
            "4443 2345 4564 1231",
            "A Credit Card",
            "23/28",
            1030.99,
            "Union",
            MultiViewEnum.ORANGE
        ),
    )
}