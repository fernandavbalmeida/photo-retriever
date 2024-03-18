package com.helloclue.androidassignment.database.entity
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.helloclue.androidassignment.core.model.data.Photo

/**
 * Defines an ClueAa photo resource.
 */
@Entity(
    tableName = "photos",
)
data class PhotoEntity(
    @PrimaryKey
    val id: String,
    val color: String,
    val downloads: Int,
    val likes: Int,
    val description: String?,
    val name: String?,
    val city: String?,
    val country: String?,
    val thumbUrl: String,
    val regularUrl: String,)



fun PhotoEntity.asExternalModel(): Photo {
    return Photo(
        id = id,
        color = color,
        downloads = downloads,
        likes = likes,
        description = description,
        name = name,
        city = city,
        country = country,
        regularUrl =regularUrl,
        thumbUrl = thumbUrl
    )
}