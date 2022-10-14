package com.example.core_data.local

import com.example.core_database.room.dao.TextDao
import com.example.core_database.room.entity.TextEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TextLocalDataSourceImpl @Inject constructor(private val textDao: TextDao) :
    TextLocalDataSource {

    override suspend fun insertTextItem(item: TextEntity): Boolean =
        try {
            val result = textDao.insertText(item)
            result > 0
        } catch (e: Exception) {
            false
        }

    override suspend fun deleteTextItem(item: TextEntity): Boolean =
        try {
            val result = textDao.deleteText(item)
            result >= 0
        } catch (e: Exception) {
            false
        }

    override fun getTextEntityList(): Flow<List<TextEntity>> =
        textDao.getAllTexts()
}