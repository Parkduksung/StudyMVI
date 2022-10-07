package com.example.studymvi.presenter.text_list

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.studymvi.presenter.SampleViewModel
import com.example.studymvi.presenter.text_list.component.TextScreen
import com.example.studymvi.room.entity.TextEntity

@Composable
fun TextListScreen(
    viewModel: SampleViewModel = hiltViewModel()
) {

    Log.d("결과", "TextListScreen")

    val textListState =
        viewModel.texts.collectAsState(initial = com.example.studymvi.presenter.Result.Loading).value

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        when (textListState) {
            is com.example.studymvi.presenter.Result.Success<List<TextEntity>> -> {
                items(textListState.data) { item ->
                    TextScreen(item, onItemClick = viewModel::removeTextItem)
                }
            }

            is com.example.studymvi.presenter.Result.Loading -> {
                //todo
            }

            is com.example.studymvi.presenter.Result.Error -> {
                //todo
            }
        }


    }
}