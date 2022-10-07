package com.example.studymvi.presenter.text_list

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
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

    when (textListState) {
        is com.example.studymvi.presenter.Result.Success<List<TextEntity>> -> {

            if (textListState.data.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    items(textListState.data) { item ->
                        TextScreen(item, onItemClick = viewModel::removeTextItem)
                    }
                }
            } else {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "저장된 입력 내용이 없습니다.")
                }
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