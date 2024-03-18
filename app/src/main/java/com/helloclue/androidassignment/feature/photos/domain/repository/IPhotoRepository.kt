package com.helloclue.androidassignment.feature.photos.domain.repository

import com.helloclue.androidassignment.core.model.data.Photo
import com.helloclue.androidassignment.util.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Data layer interface for photos.
 */
interface IPhotoRepository {
    fun getPhotos(): Flow<Resource<List<Photo>>>

    suspend fun getRandomPhoto(): Flow<Resource<Photo>>

    suspend fun getPhotoById(photoId: String): Flow<Resource<Photo>>
}