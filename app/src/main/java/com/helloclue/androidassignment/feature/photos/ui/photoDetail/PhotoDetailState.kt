package com.helloclue.androidassignment.feature.photos.ui.photoDetail

import com.helloclue.androidassignment.core.model.data.Photo

data class PhotoDetailState(val isLoading:Boolean = false, val photo: Photo? = null)