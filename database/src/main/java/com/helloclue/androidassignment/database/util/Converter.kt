package com.helloclue.androidassignment.database.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.helloclue.androidassignment.database.entity.PhotoEntity


class UrlsTypeConverter {

    @TypeConverter
    fun fromUrls(urls: PhotoEntity.Urls): String {
        return Gson().toJson(urls)
    }

    @TypeConverter
    fun toUrls(urlsString: String): PhotoEntity.Urls {
        return Gson().fromJson(urlsString, PhotoEntity.Urls::class.java)
    }
}