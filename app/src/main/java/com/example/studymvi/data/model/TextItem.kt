package com.example.studymvi.data.model

import android.icu.util.Calendar
import com.example.studymvi.room.entity.TextEntity

data class TextItem(
    val text: String,
    val date: Long = Calendar.getInstance().timeInMillis
) {

    fun toTextEntity(): TextEntity =
        TextEntity(
            text = text,
            date = date
        )

}