package com.helloclue.androidassignment.feature.photos.domain.data

import com.helloclue.androidassignment.core.model.data.Photo
import kotlinx.coroutines.flow.Flow

/**
 * Interface representing network calls to the NIA backend
 */
interface IPhotoLocalDataSource {
    suspend fun insertPhoto(photo: Photo)

    fun getPhoto(photoId: String): Flow<Photo>

    fun getPhotos(): Flow<List<Photo>>
}