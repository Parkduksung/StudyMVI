package com.example.feature_text

import com.example.common.UnidirectionalViewModel
import com.example.core_database.room.entity.TextEntity

interface TextListContract :
    UnidirectionalViewModel<TextListContract.Event, TextListContract.State> {

    data class State(
        val textList: List<TextEntity> = emptyList(),
        val totalTextCount: Int = 0,
        val preferenceText: String = ""
    )

    sealed class Event {
        data class InsertTextItem(val text: String) : Event()
        data class DeleteTextEntity(val textEntity: TextEntity) : Event()
    }

}