package com.example.studymvi.di

import com.example.studymvi.data.repo.TextRepository
import com.example.studymvi.data.repo.TextRepositoryImpl
import com.example.studymvi.data.source.local.TextLocalDataSource
import com.example.studymvi.data.source.local.TextLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun provideTextRepository(textRepositoryImpl: TextRepositoryImpl): TextRepository

    @Singleton
    @Binds
    abstract fun provideTextLocalDataSource(textLocalDataSourceImpl: TextLocalDataSourceImpl): TextLocalDataSource

}