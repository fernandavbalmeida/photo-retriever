package com.helloclue.androidassignment.feature.photos.domain.usecase

import com.helloclue.androidassignment.core.model.data.Photo
import com.helloclue.androidassignment.feature.photos.domain.repository.IPhotoRepository
import com.helloclue.androidassignment.util.Resource
import kotlinx.coroutines.flow.Flow

class GetPhotoUseCase(private val photoRepository: IPhotoRepository) {
    suspend operator fun invoke(photoId: String): Flow<Resource<Photo>> = photoRepository.getPhotoById(photoId)
}