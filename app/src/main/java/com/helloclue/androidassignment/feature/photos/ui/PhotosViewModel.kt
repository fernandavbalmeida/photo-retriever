package com.helloclue.androidassignment.feature.photos.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helloclue.androidassignment.core.model.data.Photo
import com.helloclue.androidassignment.feature.photos.domain.usecase.GetPhotosUseCase
import com.helloclue.androidassignment.feature.photos.domain.usecase.GetRandomPhotoUseCase
import com.helloclue.androidassignment.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase,
    private val getRandomPhotoUseCase: GetRandomPhotoUseCase,
) : ViewModel() {

    private val stateFlow = MutableStateFlow(PhotosState())

    val states: Flow<PhotosState>
        get() = stateFlow

    init {
        refreshPhotos()
    }

    private fun refreshPhotos() {
        viewModelScope.launch {
            getPhotosUseCase().collect { result ->
                when (result) {
                    is Resource.Success<List<Photo>> -> {
                        result.data?.let { photos ->
                            stateFlow.value = stateFlow.value.copy(
                                photos = photos
                            )
                        }
                        stateFlow.value = stateFlow.value.copy(isLoading = false, errorMessage = null)
                    }

                    is Resource.Error<List<Photo>> -> {
                        stateFlow.value =
                            stateFlow.value.copy(isLoading = false, errorMessage = result.message)
                    }

                    is Resource.Loading<List<Photo>> -> {
                        stateFlow.value = stateFlow.value.copy(isLoading = result.isLoading)
                    }
                }
            }
        }
    }

    fun loadRandomPhoto() {
        stateFlow.value =
            stateFlow.value.copy(isLoadingPhoto = true)

        viewModelScope.launch {
            getRandomPhotoUseCase().runCatching {
                collect { result ->
                    when (result) {
                        is Resource.Success<Photo> -> {
                            result.data?.let { photos ->
                                stateFlow.value = stateFlow.value.copy(
                                    photos = mergeItems(photos)
                                )
                                stateFlow.value = stateFlow.value.copy(isLoadingPhoto = false, errorMessage = null)
                            }
                        }

                        is Resource.Error<Photo> -> {
                            stateFlow.value = stateFlow.value.copy(
                                isLoadingPhoto = false,
                                errorMessage = result.message
                            )
                        }

                        is Resource.Loading<Photo> -> {
                            stateFlow.value =
                                stateFlow.value.copy(isLoadingPhoto = result.isLoading)
                        }
                    }
                }
            }.getOrElse { Log.e("Dsfsf", "sdfsff") }
        }

    }

    private fun mergeItems(photo: Photo): List<Photo> {
        val mutableItems = stateFlow.value.photos.toMutableList()
        return mutableItems + mutableListOf(photo)
    }
}