package com.helloclue.androidassignment.feature.photos.data.repository

import com.helloclue.androidassignment.core.model.data.Photo
import com.helloclue.androidassignment.feature.photos.domain.data.IPhotoLocalDataSource
import com.helloclue.androidassignment.feature.photos.domain.data.IPhotoRemoteDataSource
import com.helloclue.androidassignment.feature.photos.domain.repository.IPhotoRepository
import com.helloclue.androidassignment.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PhotoRepository
@Inject
constructor(
    private val photoRemoteSource: IPhotoRemoteDataSource,
    private val localDataSource: IPhotoLocalDataSource
) : IPhotoRepository {
    override  fun getPhotos(): Flow<Resource<List<Photo>>> =
        flow {
            val localPhotos = localDataSource.getPhotos().firstOrNull()
            if (localPhotos.isNullOrEmpty()) {
                val remotePhotos = photoRemoteSource.getPhoto().getOrNull()
                remotePhotos?.let { photos ->
                    localDataSource.insertPhoto(photos)
                    emit(Resource.Success(listOf(photos)))
                } ?: run {
                    emit(Resource.Error("No photo found"))
                }
            } else {
                emit(Resource.Success(localPhotos))
            }
        }

    override suspend fun getRandomPhoto(): Flow<Resource<Photo>> =
        flow {
            emit(Resource.Loading(true))
            val photo = photoRemoteSource.getPhoto().getOrNull()
            if (photo != null) {
                emit(Resource.Success(photo))
            } else {
                emit(Resource.Error("Was not possible to load photo"))
            }
            //TODO save in db if doesnt exist
        }

    override suspend fun getPhotoById(photoId: String): Flow<Resource<Photo>> =
        flow {
            emit(Resource.Loading(true))
            val photo = localDataSource.getPhoto(photoId).firstOrNull()
            if (photo != null) {
                emit(Resource.Success(photo))
            } else {
                emit(Resource.Error("There was a problem loading photo"))
            }
        }
}