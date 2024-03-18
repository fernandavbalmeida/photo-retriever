package com.helloclue.androidassignment.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.helloclue.androidassignment.database.entity.PhotoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhoto(photoEntity: PhotoEntity)

    @Query(
        value = """
        SELECT * FROM photos
        WHERE id = :photoId
    """,
    )
    fun getPhoto(photoId: String): Flow<PhotoEntity>

    @Query(value = "SELECT * FROM photos")
    fun getPhotos(): Flow<List<PhotoEntity>>
}