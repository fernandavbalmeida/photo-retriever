package com.helloclue.androidassignment.database.di

import android.content.Context
import androidx.room.Room
import com.helloclue.androidassignment.database.ClueAaDatabase
import com.helloclue.androidassignment.database.PhotoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context,
    ): ClueAaDatabase {
        return Room.databaseBuilder(
            context,
            ClueAaDatabase::class.java,
            APP_DATABASE_NAME,
        ).build()
    }

    @Singleton
    @Provides
    fun provideRocketDao(database: ClueAaDatabase): PhotoDao {
        return database.photoDao()
    }
}
private const val APP_DATABASE_NAME = "clue_database"