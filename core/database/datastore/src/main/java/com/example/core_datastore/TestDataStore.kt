package com.example.core_datastore

import kotlinx.coroutines.flow.Flow

interface TestDataStore {

    val text: Flow<String>

    suspend fun updateTestString(text: String)
}