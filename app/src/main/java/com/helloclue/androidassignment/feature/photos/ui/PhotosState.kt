package com.helloclue.androidassignment.feature.photos.ui

import com.helloclue.androidassignment.core.model.data.Photo

data class PhotosState(
    val isLoading: Boolean = false,
    val isLoadingPhoto: Boolean = false,
    val errorMessage: String? = null,
    val photos: List<Photo> = emptyList()
)