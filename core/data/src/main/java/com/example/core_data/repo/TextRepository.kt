package com.example.core_data.repo


import com.example.studymvi.model.Text
import kotlinx.coroutines.flow.Flow

interface TextRepository {

    val textList: Flow<List<Text>>

    val testTextPreferences: Flow<String>

    suspend fun insertTextItem(item: Text): Long

    suspend fun deleteTextItem(item: Text): Int

    suspend fun updateTestString(text: String)

}