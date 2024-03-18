package com.helloclue.androidassignment.feature.photos.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.helloclue.androidassignment.core.ui.AddLoadingButton
import com.helloclue.androidassignment.feature.photos.ui.widget.PhotoItem

@Composable
fun PhotosScreen(
    viewModel: PhotosViewModel = hiltViewModel(),
    onPhotoClick: (String) -> Unit,
) {
    val state: PhotosState by viewModel.states.collectAsState(
        initial = PhotosState()
    )
    val snackbarHostState = remember { SnackbarHostState() }

    Box(modifier = Modifier.fillMaxSize()) {

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color.Black
            )
        } else if (state.photos.isNotEmpty()) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.SpaceBetween, // Add vertical padding
                horizontalArrangement = Arrangement.SpaceBetween, // Add horizontal padding

            ) {
                itemsIndexed(state.photos) { _, photo ->
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable {
                                onPhotoClick(photo.id)
                            }
                    ) {
                        PhotoItem(photo.thumbUrl)
                    }
                }
            }
        }
        if (state.errorMessage != null) {
            Text(
                "There was an error loading photos",
                modifier = Modifier.align(Alignment.Center)
            )
        }
        AddLoadingButton(
            isLoading = state.isLoadingPhoto,
            onClick = { viewModel.loadRandomPhoto() },
            modifier = Modifier
                .padding(16.dp)
                .width(80.dp)
                .align(Alignment.BottomEnd),
        )
    }
}

