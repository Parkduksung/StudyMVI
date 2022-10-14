package com.example.feature_text

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core_database.room.entity.TextEntity
import com.example.feature_text.component.TextScreen


@Composable
fun SampleScreen(
    viewModel: TextListViewModel = hiltViewModel()
) {

    val uiState = viewModel.uiState.collectAsState()

    Column(Modifier.fillMaxSize()) {
        InputText(totalTextCountUiState = uiState.value.totalTextCountUiState)
        TextListScreen(textUiState = uiState.value.textUiState)
    }

}

@Composable
fun InputText(
    viewModel: TextListViewModel = hiltViewModel(),
    totalTextCountUiState: TotalTextCountUiState
) {

    val input = viewModel.inputState.value

    Column {

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Input Text : $input", modifier = Modifier.padding(10.dp))

            when (totalTextCountUiState) {

                is TotalTextCountUiState.Success -> {
                    Text(
                        text = "TextCount : ${totalTextCountUiState.totalCount}",
                        modifier = Modifier.padding(10.dp)
                    )
                }

                TotalTextCountUiState.Loading -> {
                    //todo
                }

                TotalTextCountUiState.Error -> {
                    //todo
                }

            }
        }

        OutlinedTextField(
            value = input,
            onValueChange = viewModel::onInputChange,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.LightGray,
                unfocusedBorderColor = Color.LightGray
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Send
            ),
            keyboardActions = KeyboardActions(
                onSend = {
                    viewModel.insertTextItem()
                }
            ),
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )
    }
}


@Composable
fun TextListScreen(
    viewModel: TextListViewModel = hiltViewModel(),
    textUiState: TextUiState
) {

    when (textUiState) {

        is TextUiState.Success -> {
            if (textUiState.texts.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    items(textUiState.texts) { item: TextEntity ->
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
        TextUiState.Loading -> {
            //todo
        }

        TextUiState.Error -> {
            //todo
        }
    }

}