package com.helloclue.androidassignment.feature.photo.data.remote

import com.google.common.truth.Truth.assertThat
import com.helloclue.androidassignment.core.model.data.Photo
import com.helloclue.androidassignment.feature.photos.data.remote.PhotoRemoteDataSource
import com.helloclue.androidassignment.feature.photos.data.remote.dto.PhotoDto
import com.helloclue.androidassignment.feature.photos.data.remote.dto.Urls
import com.helloclue.androidassignment.network.PhotoApiService
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class PhotoRemoteDataSourceTest {

    @Mock
    lateinit var apiService: PhotoApiService

    @InjectMocks
    private lateinit var remoteDataSource: PhotoRemoteDataSource

    @Test
    fun `returns valid photos`(): Unit = runBlocking {
        val photoDto = createMockPhotoDto()
        val photo = createMockPhoto(photoDto)
        ArrangeBuilder().withPhoto(photoDto)

        val result = remoteDataSource.getPhoto()

        assertThat(result.isSuccess).isTrue()
        assertThat(result.getOrNull() == photo)
    }

    @Test
    fun `get photos fails`(): Unit = runBlocking {
        ArrangeBuilder().withPhotoFails()

        val result = remoteDataSource.getPhoto()

        assertThat(result.isFailure).isTrue()
    }

    private inner class ArrangeBuilder {
        suspend fun withPhoto(
            photos: PhotoDto,
        ) = apply {
            whenever(apiService.getRandomPhoto())
                .thenReturn(Response.success(photos))
        }

        suspend fun withPhotoFails() = apply {
            whenever(apiService.getRandomPhoto())
                .thenReturn(
                    Response.error(
                        403,
                        "errorResponseBody".toResponseBody("application/json".toMediaTypeOrNull())
                    )
                )
        }
    }
}

fun createMockPhotoDto(): PhotoDto {
    val urls = Urls(
        regular = "regular",
        thumb = "thumb"
    )

    return PhotoDto(
        id = "123",
        color = "#FFFFFF",
        downloads = 100,
        likes = 50,
        description = "A beautiful photo",
        name = "name",
        city = "city",
        country = "DE",
        urls = urls
    )
}

fun createMockPhoto(photoDto: PhotoDto): Photo {
    return Photo(
        id = photoDto.id,
        color = photoDto.color,
        downloads = photoDto.downloads,
        likes = photoDto.likes,
        description = photoDto.description,
        name = photoDto.name,
        city = photoDto.city,
        country = photoDto.country,
        thumbUrl = photoDto.urls.thumb,
        regularUrl = photoDto.urls.regular
    )
}