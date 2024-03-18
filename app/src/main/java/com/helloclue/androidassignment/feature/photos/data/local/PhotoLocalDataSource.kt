package com.helloclue.androidassignment.feature.photos.data.local

import com.helloclue.androidassignment.core.model.data.Photo
import com.helloclue.androidassignment.database.PhotoDao
import com.helloclue.androidassignment.database.entity.PhotoEntity
import com.helloclue.androidassignment.database.entity.asExternalModel
import com.helloclue.androidassignment.feature.photos.data.model.asEntity
import com.helloclue.androidassignment.feature.photos.domain.data.IPhotoLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PhotoLocalDataSource
@Inject
constructor(private val photoDao: PhotoDao) : IPhotoLocalDataSource {
    override suspend fun insertPhoto(photo: Photo) {
        photoDao.insertPhoto(photo.asEntity())
    }

    override fun getPhoto(photoId: String): Flow<Photo> =
        photoDao.getPhoto(photoId)
            .filterNotNull()
            .map (PhotoEntity::asExternalModel)

    override fun getPhotos(): Flow<List<Photo>> =
        photoDao.getPhotos().map { photoList ->
            photoList.map(PhotoEntity::asExternalModel)
        }

}