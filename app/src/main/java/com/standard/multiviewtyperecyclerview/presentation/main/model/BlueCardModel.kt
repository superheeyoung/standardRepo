package com.standard.multiviewtyperecyclerview.presentation.main.model

import android.os.Parcelable
import com.standard.multiviewtyperecyclerview.presentation.main.main.MultiViewEnum
import kotlinx.android.parcel.Parcelize

//bundle로 보내기 위하여 parcelize 추가
@Parcelize
data class BlueCardModel(
    val userName: String,
    val cardNumber: String,
    val cardType: String,
    val period: String,
    val balance: Double,
    val cardManager: String,
    val cardViewType : MultiViewEnum
) : Parcelable