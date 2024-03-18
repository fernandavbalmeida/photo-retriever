package com.helloclue.androidassignment.database

`import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.helloclue.androidassignment.database.dao.PhotoDao
import com.helloclue.androidassignment.database.entity.PhotoEntity
import com.helloclue.androidassignment.database.util.UrlsTypeConverter

@Database(
    entities = [
        PhotoEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
@TypeConverters(UrlsTypeConverter::class)
abstract class ClueAaDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao
}
`