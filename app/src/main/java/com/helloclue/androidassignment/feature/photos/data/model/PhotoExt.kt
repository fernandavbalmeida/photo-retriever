package com.helloclue.androidassignment.feature.photos.data.model

import com.helloclue.androidassignment.core.model.data.Photo
import com.helloclue.androidassignment.database.entity.PhotoEntity

fun Photo.asEntity(): PhotoEntity {
    return PhotoEntity(
        id = id,
        color = color,
        downloads = downloads,
        likes = likes,
        description = description,
        name = name,
        city = city,
        country = country,
        thumbUrl = thumbUrl,
        regularUrl= regularUrl
    )
}