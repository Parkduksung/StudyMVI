package com.example.core_datastore.di

import com.example.core_datastore.TestDataStore
import com.example.core_datastore.TestDataStoreImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface DataStoreModule {

    @Singleton
    @Binds
    fun bindsTestDataStore(
        testDataStoreImpl: TestDataStoreImpl
    ): TestDataStore

}