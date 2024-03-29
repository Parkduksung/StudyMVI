package com.example.studymvi.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "text_table")
data class Text(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "text") val text: String,
    @ColumnInfo(name = "date") val date: Long
)