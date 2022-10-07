package com.example.studymvi.di

import android.content.Context
import androidx.room.Room
import com.example.studymvi.room.dao.TextDao
import com.example.studymvi.room.database.TextDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Provides
    @Singleton
    fun provideTextDatabase(@ApplicationContext context: Context): TextDatabase =
        Room.databaseBuilder(context, TextDatabase::class.java, "text_table").build()

    @Provides
    @Singleton
    fun provideTextDao(@ApplicationContext context: Context): TextDao =
        provideTextDatabase(context).textDao()

}