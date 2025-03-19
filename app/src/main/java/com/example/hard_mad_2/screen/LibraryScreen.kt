package com.example.hard_mad_2.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.hard_mad_2.R
import com.example.hard_mad_2.components.library_screen.LatestCarousel
import com.example.hard_mad_2.data_stub.Data
import com.example.hard_mad_2.models.GridItem
import com.example.hard_mad_2.ui.theme.Alumni


@Composable
fun LibraryScreenContent() {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 24.dp, bottom = 24.dp)
            .background(color = MaterialTheme.colorScheme.background),
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item(span = { GridItemSpan(maxLineSpan) }) {
            Text(
                modifier = Modifier.padding(top = 24.dp, bottom = 16.dp),
                text = stringResource(R.string.library_header),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.secondary
            )
        }
        item(span = { GridItemSpan(maxLineSpan) }) {
            Text(
                modifier = Modifier.padding(bottom = 16.dp),
                text = stringResource(R.string.latest_books),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
        item(span = { GridItemSpan(maxLineSpan) }) {
            LatestCarousel()
        }
        item(span = { GridItemSpan(maxLineSpan) }) {
            Text(
                modifier = Modifier.padding(top = 24.dp, bottom = 16.dp),
                text = stringResource(R.string.popular_books),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
        items(Data.gridList) { item ->
            BookCollectionItem(item)
        }
    }
}


@Composable
fun BookCollectionItem(book: GridItem) {
    Column {
        AsyncImage(
            model = book.img,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(8.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = book.name,
            fontFamily = Alumni,
            fontWeight = FontWeight.Bold,
            lineHeight = 14.sp,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.height(4.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = book.author,
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.primary
        )
    }
}