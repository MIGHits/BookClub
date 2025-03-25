package com.example.hard_mad_2.components.book_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hard_mad_2.models.SearchItem

@Composable
fun BookShortInfo(book: SearchItem) {
    Text(
        text = book.name,
        style = MaterialTheme.typography.headlineLarge,
        color = MaterialTheme.colorScheme.primary
    )
    Row(modifier = Modifier.padding(bottom = 16.dp)) {
        book.authors?.forEachIndexed { index, item ->
            Text(
                text = if (index != book.authors.size - 1) {
                    "$item, "
                } else {
                    item
                },
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
            )
        }
    }

    val paragraphs = book.description.split("\n").map { it.trim() }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        paragraphs.forEach { paragraph ->
            Text(
                text = paragraph,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}