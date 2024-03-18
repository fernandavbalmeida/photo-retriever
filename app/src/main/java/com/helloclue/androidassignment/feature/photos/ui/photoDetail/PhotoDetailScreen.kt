package com.helloclue.androidassignment.feature.photos.ui.photoDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.helloclue.androidassigment.designsystem.ClueAaIcons
import com.helloclue.androidassignment.feature.photos.ui.widget.PhotoItem

@Composable
fun PhotoDetailScreen(
    photoId: String?
) {
    val viewModel: PhotoDetailViewModel = hiltViewModel()

    if (photoId != null) {
        LaunchedEffect(photoId) {
            viewModel.getPhotoById(photoId)
        }
    }

    val photo = viewModel.state.photo

    photo?.let {
        with(it) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                PhotoItem(url = regularUrl)
                Text(
                    text = regularUrl,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                description?.let { descr ->
                    Text(
                        text = descr,
                        style = TextStyle(
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                }
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = ClueAaIcons.Location,
                        contentDescription = "Map",
                        tint = Color.Gray,
                        modifier = Modifier
                            .size(24.dp)
                            .padding(end = 8.dp)
                    )
                    Text(
                        text = it.city ?: "",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier.weight(1f)
                    )

                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Download com.helloclue.androidassigment.designsystem.Icon",
                        tint = Color.Gray,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = downloads.toString(),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier.padding(start = 8.dp, end = 16.dp)
                    )

                    Icon(
                        imageVector = Icons.Default.ThumbUp,
                        contentDescription = "Favorite com.helloclue.androidassigment.designsystem.Icon",
                        tint = Color.Gray,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = likes.toString(),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}