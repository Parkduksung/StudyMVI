package com.example.studymvi.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.studymvi.room.dao.TextDao
import com.example.studymvi.room.entity.TextEntity

@Database(entities = [TextEntity::class], version = 1)
abstract class TextDatabase : RoomDatabase() {
    abstract fun textDao(): TextDao
}