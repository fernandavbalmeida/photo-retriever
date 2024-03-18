package com.helloclue.androidassignment.feature.photos.di

import com.helloclue.androidassignment.feature.photos.domain.repository.IPhotoRepository
import com.helloclue.androidassignment.feature.photos.domain.usecase.GetPhotoUseCase
import com.helloclue.androidassignment.feature.photos.domain.usecase.GetPhotosUseCase
import com.helloclue.androidassignment.feature.photos.domain.usecase.GetRandomPhotoUseCase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object PhotosDomainModule {

    @ViewModelScoped
    @Provides
    fun providePhotosUseCases(
        repository: IPhotoRepository,
    ): GetPhotosUseCase = GetPhotosUseCase(repository)

    @ViewModelScoped
    @Provides
    fun provideTrackerUseCases(
        repository: IPhotoRepository,
    ): GetRandomPhotoUseCase = GetRandomPhotoUseCase(repository)

    @ViewModelScoped
    @Provides
    fun providePhotoUseCases(
        repository: IPhotoRepository,
    ): GetPhotoUseCase = GetPhotoUseCase(repository)
}