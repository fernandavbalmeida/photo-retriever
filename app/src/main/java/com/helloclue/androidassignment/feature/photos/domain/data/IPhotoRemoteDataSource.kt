package com.helloclue.androidassignment.feature.photos.domain.data

import com.helloclue.androidassignment.core.model.data.Photo

/**
 * Interface representing network calls to unsplash api
 */
interface IPhotoRemoteDataSource {

    suspend fun getPhoto(): Result<Photo>
}