package com.helloclue.androidassignment.feature.photos.data.remote.dto

data class PhotoDto(
    val id: String,
    val color: String,
    val downloads: Int,
    val likes: Int,
    val description: String?,
    val name: String?,
    val city: String?,
    val country: String?,
    val urls: Urls
)


data class Urls(
    val regular: String,
    val thumb: String
)
