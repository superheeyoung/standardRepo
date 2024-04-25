package com.standard.multiviewtyperecyclerview.presentation.model

import android.os.Parcelable
import com.standard.multiviewtyperecyclerview.presentation.main.MultiViewEnum
import kotlinx.android.parcel.Parcelize

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