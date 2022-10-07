package com.example.studymvi.presenter.text_list.component

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.studymvi.data.model.TextItem
import com.example.studymvi.room.entity.TextEntity

@Composable
fun TextScreen(
    item: TextEntity,
    onItemClick: (TextEntity) -> Unit
) {
    Log.d("결과", "TextScreen")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(5.dp)
            .border(1.dp, Color.Black, RectangleShape)
            .clickable { onItemClick(item) },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = item.text)
    }
}

