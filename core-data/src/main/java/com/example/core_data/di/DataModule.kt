package com.example.core_data.di

import com.example.core_data.local.TextLocalDataSource
import com.example.core_data.local.TextLocalDataSourceImpl
import com.example.core_data.repo.TextRepository
import com.example.core_data.repo.TextRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindsTextRepository(
        textRepositoryImpl: TextRepositoryImpl
    ): TextRepository

    @Singleton
    @Binds
    fun bindsTextLocalDataSource(
        textLocalDataSourceImpl: TextLocalDataSourceImpl
    ): TextLocalDataSource

}
