package com.helloclue.androidassignment.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.helloclue.androidassignment.feature.photos.navigation.PHOTO_ID
import com.helloclue.androidassignment.feature.photos.navigation.navigateToPhotoDetail
import com.helloclue.androidassignment.feature.photos.ui.PhotosScreen
import com.helloclue.androidassignment.feature.photos.ui.photoDetail.PhotoDetailScreen


@Composable
fun ClueAaNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Route.PHOTOS
    ) {
        composable(Route.PHOTOS) {
            PhotosScreen(onPhotoClick = navController::navigateToPhotoDetail)
        }
        composable(
            route = Route.PHOTO_DETAIL + "/{$PHOTO_ID}",
            arguments = listOf(
                navArgument(PHOTO_ID) {
                    type = NavType.StringType
                })
        ) {
            val photoId = it.arguments?.getString(PHOTO_ID)
            PhotoDetailScreen(photoId)
        }
    }
}
