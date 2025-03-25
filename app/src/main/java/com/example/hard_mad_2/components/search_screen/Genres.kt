package com.example.hard_mad_2.components.search_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hard_mad_2.models.SearchBlockType

@Composable
fun Genres(rowItems: List<String>, onClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        rowItems.forEach { item ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentSize()
            ) {
                SearchScreenGridItem(item, SearchBlockType.GENRE, onClick = { onClick(item) })
            }
        }
    }
}