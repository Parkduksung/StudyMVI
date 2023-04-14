package com.example.core_data.repo

import com.example.core_database.room.dao.TextDao
import com.example.core_datastore.TestDataStore
import com.example.studymvi.model.Text
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TextRepositoryImpl @Inject constructor(
    private val textDao: TextDao,
    private val testDataStore: TestDataStore
) :
    TextRepository {

    override val testTextPreferences: Flow<String>
        get() = testDataStore.text

    override val textList: Flow<List<Text>>
        get() = textDao.getAllTexts()

    override suspend fun insertTextItem(item: Text): Long =
        textDao.insertText(item)

    override suspend fun deleteTextItem(item: Text): Int =
        textDao.deleteText(item)

    override suspend fun updateTestString(text: String) {
        testDataStore.updateTestString(text)
    }
}
