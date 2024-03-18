package com.helloclue.androidassignment.feature.photos.data.remote

import com.helloclue.androidassignment.core.model.data.Photo
import com.helloclue.androidassignment.feature.photos.data.mapper.toPhoto
import com.helloclue.androidassignment.feature.photos.domain.data.IPhotoRemoteDataSource
import com.helloclue.androidassignment.network.PhotoApiService
import javax.inject.Inject

class PhotoRemoteDataSource
@Inject
constructor(private val api: PhotoApiService) : IPhotoRemoteDataSource {

    override suspend fun getPhoto(): Result<Photo>  =
        runCatching {
            api.getRandomPhoto().run {
                if (isSuccessful) {
                    body()?.toPhoto()?.let {
                        Result.success(it)
                    } ?: Result.failure(Exception("Failed to convert photo"))
                } else {
                    val errorBody = errorBody()?.string()
                    Result.failure(Exception("Failed to fetch photos: $errorBody"))
                }
            }
        }.getOrElse { Result.failure(it) }
}

