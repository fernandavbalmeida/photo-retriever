package com.helloclue.androidassignment.core.model.data

data class Photo(
    val id: String,
    val color: String,
    val downloads: Int,
    val likes: Int,
    val description: String?,
    val name: String?,
    val city: String?,
    val country: String?,
    val thumbUrl: String,
    val regularUrl: String
)

