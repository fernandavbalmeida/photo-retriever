package com.helloclue.androidassignment.network

import com.helloclue.androidassignment.feature.photos.data.remote.dto.PhotoDto
import retrofit2.Response
import retrofit2.http.GET

interface PhotoApiService {

    @GET("photos/random")
    suspend fun getRandomPhoto(): Response<PhotoDto>

    companion object{
        const val BASE_URL = "https://api.unsplash.com/"
        const val API_KEY= "VmyrFhk9hwKBkrm9Dep6uDYFw15Aqh10yCTTg8ue4WE"
    }

}
