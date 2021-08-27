package com.example.kotlinflow

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LocalDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUsersToTable()

    @Query("SELECT * FROM registered_users")
    fun getUsers(): RegisterUserResponseModelClass
}
