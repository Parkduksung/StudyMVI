package com.example.studymvi.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SampleActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column() {
                SampleBox()
            }
        }
    }
}


@Composable
fun SampleBox(
    viewModel: SampleViewModel = hiltViewModel()
) {

    val input = viewModel.inputState.value

    Column {

        Text(text = "Input Text : $input", modifier = Modifier.padding(10.dp))

        OutlinedTextField(
            value = input,
            onValueChange = viewModel::onInputChange,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )
    }
}
