package com.example.hard_mad_2.components.bookmarks_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BookProgressBar(progress: Float) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .weight(progress)
                .size(4.dp)
                .background(
                    shape = RoundedCornerShape(24.dp),
                    color = MaterialTheme.colorScheme.primary
                )
        )
        if (progress != 1f) {
            Spacer(Modifier.width(4.dp))

            Box(
                modifier = Modifier
                    .weight(1 - progress)
                    .background(
                        color = MaterialTheme.colorScheme.onPrimary,
                        shape = RoundedCornerShape(24.dp)
                    ),
                contentAlignment = Alignment.CenterEnd
            ) {
                Box(
                    modifier = Modifier
                        .size(4.dp)
                        .background(
                            shape = CircleShape,
                            color = MaterialTheme.colorScheme.primary
                        )
                )
            }
        }
    }
}