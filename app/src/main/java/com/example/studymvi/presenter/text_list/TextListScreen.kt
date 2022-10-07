package com.example.studymvi.presenter.text_list

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.studymvi.presenter.SampleViewModel
import com.example.studymvi.presenter.text_list.component.TextScreen

@Composable
fun TextListScreen(
    viewModel: SampleViewModel = hiltViewModel()
) {

    Log.d("결과", "TextListScreen")
    val list = viewModel.listState.value

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        items(list) { item ->
            TextScreen(item, onItemClick = viewModel::removeItem)
        }
    }
}