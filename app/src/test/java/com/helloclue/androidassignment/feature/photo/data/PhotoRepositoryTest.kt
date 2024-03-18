package com.helloclue.androidassignment.feature.photo.data

import com.google.common.truth.Truth.assertThat
import com.helloclue.androidassignment.core.model.data.Photo
import com.helloclue.androidassignment.feature.photos.data.repository.PhotoRepository
import com.helloclue.androidassignment.feature.photos.domain.data.IPhotoLocalDataSource
import com.helloclue.androidassignment.feature.photos.domain.data.IPhotoRemoteDataSource
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PhotoRepositoryTest {

    @Mock
    lateinit var remoteDataSource: IPhotoRemoteDataSource

    @Mock
    lateinit var localDataSource: IPhotoLocalDataSource

    @InjectMocks
    private lateinit var repository: PhotoRepository

    @Test
    fun `returns valid photos`(): Unit = runBlocking {
        val photo =createMockPhoto()
        ArrangeBuilder().withRemotePhoto(photo)
        ArrangeBuilder().withLocalPhotos(photo)

        val result = repository.getPhotos().firstOrNull()

        assertThat(result!=null).isTrue()
        assertThat(result!!.data == listOf(photo))
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `having empty local list calls remote photo`(): Unit = runTest {
        ArrangeBuilder().withEmptyLocalPhotos()
            .withRemotePhoto(createMockPhoto())

       repository.getPhotos().firstOrNull()

        verify(remoteDataSource).getPhoto()
    }

    private inner class ArrangeBuilder {

        suspend fun withRemotePhoto(
            photo: Photo,
        ) = apply {
            whenever(remoteDataSource.getPhoto())
                .thenReturn(Result.success(photo))
        }

        suspend fun withLocalPhotos(
            photo: Photo,
        ) = apply {
            whenever(localDataSource.getPhotos())
                .thenReturn(flow {
                    emit(listOf(photo))
                })
        }

        suspend fun withRemotePhotoFails() = apply {
            whenever(remoteDataSource.getPhoto())
                .thenReturn(
                    Result.failure(
                        Exception()
                    )
                )
        }

        suspend fun withEmptyLocalPhotos(
        ) = apply {
            whenever(localDataSource.getPhotos())
                .thenReturn(flow {
                    emit(emptyList())
                })
        }
    }
}

fun createMockPhoto(): Photo {
    return Photo(
        id = "12345",
        color = "red",
        downloads = 100,
        likes = 50,
        description = "A beautiful photo",
        name = "Photo Name",
        city = "City Name",
        country = "Country Name",
        thumbUrl = "thumb",
        regularUrl = "regular"
    )
}