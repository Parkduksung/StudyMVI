package com.example.studymvi.data.source.local

import com.example.studymvi.room.dao.TextDao
import com.example.studymvi.room.entity.TextEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
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