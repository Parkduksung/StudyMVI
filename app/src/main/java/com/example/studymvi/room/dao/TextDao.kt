package com.example.studymvi.room.dao

import androidx.room.*
import com.example.studymvi.room.entity.TextEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TextDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertText(item: TextEntity): Long

    @Delete
    suspend fun deleteText(item: TextEntity): Int

    @Query("SELECT * FROM text_table")
    fun getAllTexts(): Flow<List<TextEntity>>

}