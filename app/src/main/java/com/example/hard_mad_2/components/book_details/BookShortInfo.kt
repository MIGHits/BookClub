package com.example.hard_mad_2.components.book_details

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BookShortInfo() {
    Text(
        text = "КОД ДА ВИНЧИ",
        style = MaterialTheme.typography.headlineLarge,
        color = MaterialTheme.colorScheme.primary
    )
    Text(
        text = "Дэн Браун",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(bottom = 16.dp)
    )
    Text(
        text = "Секретный код скрыт в работах Леонардо да Винчи...\n" +
                "Только он поможет найти христианские святыни, дающие немыслимые власть и могущество... \n" +
                "Ключ к величайшей тайне, над которой человечество билось веками, наконец может быть найден...",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.primary
    )
}