package com.example.studymvi

import kotlinx.coroutines.flow.Flow

interface SampleRepository {
    fun getData() : Flow<String>
}