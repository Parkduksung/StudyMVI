package com.example.feature_text.component

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
import com.example.core_database.room.entity.TextEntity
import com.example.feature_text.TextListContract

@Composable
fun TextScreen(
    item: TextEntity,
    event: (TextListContract.Event) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(5.dp)
            .border(1.dp, Color.Black, RectangleShape)
            .clickable { event.invoke(TextListContract.Event.DeleteTextEntity(item)) },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = item.text)
    }
}

