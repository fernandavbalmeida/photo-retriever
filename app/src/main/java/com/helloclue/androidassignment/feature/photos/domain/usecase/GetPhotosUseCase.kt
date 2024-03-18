package com.helloclue.androidassignment.feature.photos.domain.usecase

import com.helloclue.androidassignment.core.model.data.Photo
import com.helloclue.androidassignment.feature.photos.domain.repository.IPhotoRepository
import com.helloclue.androidassignment.util.Resource
import kotlinx.coroutines.flow.Flow

class GetPhotosUseCase(private val photoRepository: IPhotoRepository) {
    operator fun invoke(): Flow<Resource<List<Photo>>> = photoRepository.getPhotos()
}