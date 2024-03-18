package com.helloclue.androidassignment.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.helloclue.androidassignment.database.entity.PhotoEntity

@Database(
    entities = [
        PhotoEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
abstract class ClueAaDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao
}
