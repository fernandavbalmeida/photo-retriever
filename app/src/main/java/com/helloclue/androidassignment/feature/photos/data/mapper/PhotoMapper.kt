package com.helloclue.androidassignment.feature.photos.data.mapper

import com.helloclue.androidassignment.core.model.data.Photo
import com.helloclue.androidassignment.feature.photos.data.remote.dto.PhotoDto

fun PhotoDto.toPhoto(): Photo = Photo(
    id = id,
    color = color,
    downloads = downloads,
    likes = likes,
    description = description,
    name = name,
    city = city,
    country = country,
    regularUrl = urls.regular,
    thumbUrl = urls.thumb
)
