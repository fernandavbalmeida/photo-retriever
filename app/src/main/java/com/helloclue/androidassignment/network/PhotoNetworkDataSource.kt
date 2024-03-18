package com.helloclue.androidassignment.network

import com.helloclue.androidassignment.feature.photos.data.remote.dto.PhotoDto

/**
 * Interface representing network calls to the NIA backend
 */
interface PhotoNetworkDataSource {
    suspend fun getPhotos(): List<PhotoDto>
}
