package com.example.studymvi.data.source.local

import com.example.studymvi.room.entity.TextEntity
import kotlinx.coroutines.flow.Flow

interface TextLocalDataSource {

    suspend fun insertTextItem(item: TextEntity): Boolean

    suspend fun deleteTextItem(item: TextEntity): Boolean

    fun getTextEntityList(): Flow<List<TextEntity>>
}