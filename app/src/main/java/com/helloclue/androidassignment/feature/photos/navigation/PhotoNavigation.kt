package com.helloclue.androidassignment.feature.photos.navigation

import androidx.navigation.NavController
import com.helloclue.androidassignment.navigation.Route

fun NavController.navigateToPhotoDetail(photoId: String) {
    this.navigate("${Route.PHOTO_DETAIL}/$photoId") {
        launchSingleTop = true
    }
}

const val PHOTO_ID: String = "photoId"