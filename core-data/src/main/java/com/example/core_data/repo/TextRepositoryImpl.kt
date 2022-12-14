package com.example.core_data.repo

import com.example.core_database.room.dao.TextDao
import com.example.core_database.room.entity.TextEntity
import com.example.core_datastore.TestDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TextRepositoryImpl @Inject constructor(
    private val textDao: TextDao,
    private val testDataStore: TestDataStore
) :
    TextRepository {


    override val testTextPreferences: Flow<String>
        get() = testDataStore.text

    override val totalTextCount: Flow<Int>
        get() = textDao.getAllTexts().map { it.size }

    override val textEntityList: Flow<List<TextEntity>>
        get() = textDao.getAllTexts()

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

    override suspend fun updateTestString(text: String) {
        testDataStore.updateTestString(text)
    }
}
