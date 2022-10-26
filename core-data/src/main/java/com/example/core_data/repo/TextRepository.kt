package com.example.core_data.repo

import com.example.core_database.room.entity.TextEntity
import kotlinx.coroutines.flow.Flow

interface TextRepository {

    val totalTextCount: Flow<Int>

    val textEntityList: Flow<List<TextEntity>>

    val testTextPreferences : Flow<String>

    suspend fun insertTextItem(item: TextEntity): Boolean

    suspend fun deleteTextItem(item: TextEntity): Boolean


    suspend fun updateTestString(text: String)

}