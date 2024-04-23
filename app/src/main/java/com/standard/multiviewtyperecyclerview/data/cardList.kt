package com.standard.flowerrecyclerview.data

import com.standard.multiviewtyperecyclerview.data.Card
import com.standard.multiviewtyperecyclerview.presentation.MultiViewEnum

fun cardList() : List<Card> {
    return listOf(
        Card(
            "Anderson",
            "2423 3581 9503 2412",
            "A Debit Card",
            "21/27",
            3100.30,
            "Visa",
            MultiViewEnum.BLUE
        ),
        Card(
            "Jimmy",
            "1234 5678 1234 1111",
            "A Prepaid Card",
            "19/25",
            5431.40,
            "Master",
            MultiViewEnum.LIGHTBLUE
        ),
        Card(
            "Hanna",
            "4443 2345 4564 1231",
            "A Credit Card",
            "23/28",
            1030.99,
            "Union",
            MultiViewEnum.ORANGE
        )
    )
}