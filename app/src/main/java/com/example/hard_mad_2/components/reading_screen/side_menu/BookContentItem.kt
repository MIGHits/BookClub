package com.example.hard_mad_2.components.reading_screen.side_menu

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun BookContentItem(name:String,index:Int,currentIndex:Int){
    Text(
        text = name,
        style = if (index != currentIndex) MaterialTheme.typography.bodyMedium else
            MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Bold
            ),
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 13.5.dp, horizontal = 16.dp)
    )
}