package com.example.studymvi.data.repo

import com.example.studymvi.data.source.local.TextLocalDataSource
import com.example.studymvi.room.entity.TextEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TextRepositoryImpl @Inject constructor(private val textLocalDataSource: TextLocalDataSource) :
    TextRepository {

    override suspend fun insertTextItem(item: TextEntity): Boolean =
        textLocalDataSource.insertTextItem(item)

    override suspend fun deleteTextItem(item: TextEntity): Boolean =
        textLocalDataSource.deleteTextItem(item)

    override fun getTextEntityList(): Flow<List<TextEntity>> =
        textLocalDataSource.getTextEntityList()
}
