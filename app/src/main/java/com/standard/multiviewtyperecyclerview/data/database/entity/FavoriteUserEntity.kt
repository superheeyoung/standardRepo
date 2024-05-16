package com.standard.multiviewtyperecyclerview.data.database.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
@Entity
@Parcelize
data class FavoriteUserEntity(
    @PrimaryKey(autoGenerate = true)
    val uId: Int = 0,
    val avatarUrl: String,
    val loginName: String,
    val id: Int,
    val isFavorite : Boolean = false
) : Parcelable
