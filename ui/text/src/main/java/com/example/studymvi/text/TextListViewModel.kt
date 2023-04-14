package com.example.studymvi.text

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.study.domain.usecase.*
import com.example.studymvi.model.Text
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import java.util.*
import javax.inject.Inject

@HiltViewModel
internal class TextListViewModel @Inject constructor(
    textListUseCase: TextListUseCase,
    textPreferenceUseCase: TextPreferenceUseCase,
    totalTextCountUseCase: TotalTextCountUseCase,
    private val insertTextUseCase: InsertTextUseCase,
    private val deleteTextUseCase: DeleteTextUseCase,
    private val updateTextPreferenceUseCase: UpdateTextPreferenceUseCase
) :
    ViewModel(), TextListContract {

    private val mutableState = combine(
        textListUseCase(),
        totalTextCountUseCase(),
        textPreferenceUseCase()
    ) { texts, totalTextCount, testTextPreferences ->
        TextListContract.State(
            textList = texts,
            totalTextCount = totalTextCount,
            preferenceText = testTextPreferences
        )
    }
    override val state: StateFlow<TextListContract.State> = mutableState.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000L),
        TextListContract.State()
    )

    override fun event(event: TextListContract.Event) {
        when (event) {
            is TextListContract.Event.InsertTextItem -> insertAndUpdateTextItem(event.text)
            is TextListContract.Event.DeleteTextEntity -> removeTextItem(event.textEntity)
        }
    }


    private fun insertAndUpdateTextItem(text: String) {
        if (text.isNotEmpty()) {

            val textItem =
                Text(text = text, date = Calendar.getInstance().timeInMillis)

            combine(insertTextUseCase(textItem), updateTextPreferenceUseCase(textItem)) { _, _ ->

            }.catch {

            }.launchIn(viewModelScope)
        }
    }


    private fun removeTextItem(item: Text) {
        deleteTextUseCase(item)
            .catch { }
            .onEach { }
            .launchIn(viewModelScope)
    }
}
