package com.standard.multiviewtyperecyclerview.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("remote_key")
class RemoteKey (
    @PrimaryKey val nextPage : Int
)