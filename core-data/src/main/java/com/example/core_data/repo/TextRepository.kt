package com.example.core_data.repo

import com.example.core_database.room.entity.TextEntity
import kotlinx.coroutines.flow.Flow

interface TextRepository{

    fun getTotalTextCount(): Flow<Int>

    suspend fun insertTextItem(item: TextEntity): Boolean

    suspend fun deleteTextItem(item: TextEntity): Boolean

    fun getTextEntityList(): Flow<List<TextEntity>>
}