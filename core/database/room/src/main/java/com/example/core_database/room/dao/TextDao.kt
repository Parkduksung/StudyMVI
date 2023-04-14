package com.example.core_database.room.dao

import androidx.room.*
import com.example.studymvi.model.Text
import kotlinx.coroutines.flow.Flow

@Dao
interface TextDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertText(item: Text): Long

    @Delete
    suspend fun deleteText(item: Text): Int

    @Query("SELECT * FROM text_table")
    fun getAllTexts(): Flow<List<Text>>

}