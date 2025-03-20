package com.example.hard_mad_2.components.search_screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SectionHeader(text: String, paddingBottom: Int, paddingTop: Int, modifier: Modifier) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = paddingBottom.dp, top = paddingTop.dp),
        text = text,
        style = MaterialTheme.typography.headlineMedium,
        color = MaterialTheme.colorScheme.primary
    )
}