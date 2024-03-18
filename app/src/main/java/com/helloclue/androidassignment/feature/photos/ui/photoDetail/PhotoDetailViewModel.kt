package com.helloclue.androidassignment.feature.photos.ui.photoDetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helloclue.androidassignment.core.model.data.Photo
import com.helloclue.androidassignment.feature.photos.domain.usecase.GetPhotoUseCase
import com.helloclue.androidassignment.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoDetailViewModel @Inject constructor(
    private val getPhotoUseCase: GetPhotoUseCase,
) : ViewModel() {

    var state by mutableStateOf(PhotoDetailState())


    fun getPhotoById(photoId: String) {
        viewModelScope.launch {
            getPhotoUseCase(photoId).collect{
                    result ->
                when(result) {
                    is Resource.Success<Photo> -> {
                        result.data?.let { photo ->
                            state = state.copy(photo = photo)
                        }
                    }
                    is Resource.Error<Photo> -> {
                        // Handle the error case
                        state = state.copy(isLoading = false)
                    }
                    is Resource.Loading<Photo> -> {
                        state = state.copy(isLoading = result.isLoading)
                    }
                }
            }
        }
    }
}