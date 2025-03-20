package com.example.hard_mad_2.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.hard_mad_2.R
import com.example.hard_mad_2.components.BottomSpacer
import com.example.hard_mad_2.components.search_screen.BookElement
import com.example.hard_mad_2.components.search_screen.SearchScreenGridItem
import com.example.hard_mad_2.components.search_screen.SectionHeader
import com.example.hard_mad_2.data_stub.Data
import com.example.hard_mad_2.models.SearchBlockType
import com.example.hard_mad_2.state.ReadingState

@Composable
fun BookmarksScreenContent() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                modifier = Modifier.padding(top = 48.dp),
                text = stringResource(R.string.bookmarks_header),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.secondary
            )
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, end = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SectionHeader(
                    stringResource(
                        R.string.reading_now
                    ),
                    0,
                    0,
                    Modifier.weight(0.316f)
                )
                FloatingActionButton(
                    onClick = {}, modifier = Modifier
                        .weight(0.04f)
                        .aspectRatio(1f),
                    shape = CircleShape,
                    containerColor = MaterialTheme.colorScheme.primary
                ) {
                    Icon(
                        painter = painterResource(R.drawable.play_icon),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
        item {
            Row(modifier = Modifier.fillMaxWidth()) {
                BookElement(
                    Data.readingBook,
                    ReadingState(isReading = true, chapter = "Пролог", progress = 10)
                )
            }
        }
        item {
            SectionHeader(
                stringResource(R.string.favorite_books),
                8,
                16,
                Modifier
            )
        }
        items(Data.searchItems) { item ->
            BookElement(item, ReadingState())
        }
        item {
            SectionHeader(
                stringResource(R.string.quotes),
                8,
                16,
                Modifier
            )
        }
        items(
            listOf(
                "Я все еще жив",
                "Вы\u0002сокий, широкоплечий, с мертвенно-бледной кожей и редкими\n" +
                        "белыми волосами"
            )
        ) { item ->
            SearchScreenGridItem(text = item, type = SearchBlockType.QUOTES)
        }
        item {
            BottomSpacer(100)
        }
    }
}

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