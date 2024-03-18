//package com.helloclue.androidassignment.database.di
//
//import com.helloclue.androidassignment.database.ClueAaDatabase
//import com.helloclue.androidassignment.database.dao.PhotoDao
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//
//
//@Module
//@InstallIn(SingletonComponent::class)
//object DaosModule {
//    @Provides
//    fun providesPhotoDao(
//        database: ClueAaDatabase,
//    ): PhotoDao = database.photoDao()
//}
