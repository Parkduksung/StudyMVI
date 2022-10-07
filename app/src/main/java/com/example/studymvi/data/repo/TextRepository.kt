package com.example.studymvi.data.repo

import com.example.studymvi.data.source.local.TextLocalDataSource
import kotlinx.coroutines.flow.Flow

interface TextRepository : TextLocalDataSource {

    fun getTotalTextCount(): Flow<Int>

}