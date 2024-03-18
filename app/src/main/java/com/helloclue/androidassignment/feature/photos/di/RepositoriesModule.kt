package com.helloclue.androidassignment.feature.photos.di

import com.helloclue.androidassignment.feature.photos.data.local.PhotoLocalDataSource
import com.helloclue.androidassignment.feature.photos.data.remote.PhotoRemoteDataSource
import com.helloclue.androidassignment.feature.photos.data.repository.PhotoRepository
import com.helloclue.androidassignment.feature.photos.domain.data.IPhotoLocalDataSource
import com.helloclue.androidassignment.feature.photos.domain.data.IPhotoRemoteDataSource
import com.helloclue.androidassignment.feature.photos.domain.repository.IPhotoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindsPhotoRepository(
        photoRepository: PhotoRepository,
    ): IPhotoRepository

    @Binds
    fun bindsPhotoLocalDataSource(
        photoRepository: PhotoLocalDataSource,
    ): IPhotoLocalDataSource

    @Binds
    fun bindsPhotoRemoteDataSource(
        photoRemoteDataSource: PhotoRemoteDataSource
    ): IPhotoRemoteDataSource
}