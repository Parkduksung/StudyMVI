package com.example.core_database.di

import android.content.Context
import androidx.room.Room
import com.example.core_database.room.dao.TextDao
import com.example.core_database.room.database.TextDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideTextDatabase(@ApplicationContext context: Context): TextDatabase =
        Room.databaseBuilder(context, TextDatabase::class.java, "text_table").build()

    @Provides
    @Singleton
    fun provideTextDao(@ApplicationContext context: Context): TextDao =
        provideTextDatabase(context).textDao()

}