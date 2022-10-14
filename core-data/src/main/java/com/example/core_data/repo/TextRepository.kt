package com.example.core_data.repo

import com.example.core_data.local.TextLocalDataSource
import kotlinx.coroutines.flow.Flow

interface TextRepository : TextLocalDataSource {

    fun getTotalTextCount(): Flow<Int>

}