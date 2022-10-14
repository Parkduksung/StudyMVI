package com.example.core_database.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core_database.room.dao.TextDao
import com.example.core_database.room.entity.TextEntity

@Database(entities = [TextEntity::class], version = 1)
abstract class TextDatabase : RoomDatabase() {
    abstract fun textDao(): TextDao
}