package com.example.studymvi.text



import com.example.studymvi.base.UnidirectionalViewModel
import com.example.studymvi.model.Text

internal interface TextListContract :
    UnidirectionalViewModel<TextListContract.Event, TextListContract.State> {

    data class State(
        val textList: List<Text> = emptyList(),
        val totalTextCount: Int = 0,
        val preferenceText: String = ""
    )

    sealed class Event {
        data class InsertTextItem(val text: String) : Event()
        data class DeleteTextEntity(val textEntity: Text) : Event()
    }

}