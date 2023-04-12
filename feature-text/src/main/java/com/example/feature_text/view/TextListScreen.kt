package com.example.feature_text.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.common.use
import com.example.core_database.room.entity.TextEntity
import com.example.feature_text.TextListContract
import com.example.feature_text.TextListViewModel
import com.example.feature_text.component.TextScreen


@Composable
fun SampleScreen(
    viewModel: TextListViewModel = hiltViewModel()
) {

    val (state, event) = use(viewModel = viewModel)

    Column(Modifier.fillMaxSize()) {
        InputText(state = state, event = event)
        TestPreferencesScreen(state = state)
        TextListScreen(state = state, event = event)
    }
}

@Composable
fun InputText(
    state: TextListContract.State,
    event: (TextListContract.Event) -> Unit
) {

    var input by remember { mutableStateOf("") }

    Column {

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Input Text : $input", modifier = Modifier.padding(10.dp))

            Text(
                text = "TextCount : ${state.totalTextCount}",
                modifier = Modifier.padding(10.dp)
            )
        }

        OutlinedTextField(
            value = input,
            onValueChange = { input = it },
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
                    event.invoke(TextListContract.Event.InsertTextItem(input))
                }
            ),
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun TestPreferencesScreen(
    state: TextListContract.State,
) {
    Text(
        text = "SavePreferences : ${state.preferenceText}",
        modifier = Modifier.padding(10.dp)
    )
}


@Composable
fun TextListScreen(
    state: TextListContract.State,
    event: (TextListContract.Event) -> Unit
) {

    if (state.textList.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            items(state.textList) { item: TextEntity ->
                TextScreen(item, event)
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