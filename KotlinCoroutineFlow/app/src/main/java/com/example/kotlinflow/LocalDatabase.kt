package com.example.kotlinflow

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RegisterUserResponseModelClass::class], version = 1, exportSchema = false)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun getRegisteredUser(): LocalDao

    companion object {

        @Volatile
        var ROOM_DB_INSTANCE: LocalDatabase? = null

        operator fun invoke(context: Context) = synchronized(this) {
            var instance = ROOM_DB_INSTANCE

            if (instance == null) {
                val db = Room.databaseBuilder(
                    context.applicationContext,
                    LocalDatabase::class.java,
                    "registeredUsersDB"
                ).build()

                ROOM_DB_INSTANCE = db
                instance = ROOM_DB_INSTANCE
            }
            instance
        }
    }
}
