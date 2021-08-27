package com.example.kotlinflow

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "registered_users")
data class RegisterUserResponseModelClass(
    @PrimaryKey
    var id: Int?,

    @ColumnInfo(name = "registerToken")
    var token: String?
)
