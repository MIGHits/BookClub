package com.example.hard_mad_2.components.search_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.hard_mad_2.components.bookmarks_screen.BookProgressBar
import com.example.hard_mad_2.models.SearchItem
import com.example.hard_mad_2.state.ReadingState

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun BookElement(searchBook: SearchItem, readingState: ReadingState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier
                .weight(80f / 315f)
                .padding(end = 16.dp)
                .aspectRatio(0.635f)
                .clip(RoundedCornerShape(4.dp)),
            model = searchBook.img,
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(284f / 380f)
        ) {
            Text(
                text = searchBook.name.toUpperCase(Locale.current),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(Modifier.height(4.dp))
            if (readingState.isReading) {
                Text(
                    modifier = Modifier.padding(bottom = 16.dp),
                    text = readingState.chapter,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
                BookProgressBar(readingState.progress / 100f)
            } else {
                FlowRow(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    searchBook.authors?.forEachIndexed { index, item ->
                        Text(
                            text = if (index != searchBook.authors.size - 1) {
                                "$item, "
                            } else {
                                item
                            },
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}