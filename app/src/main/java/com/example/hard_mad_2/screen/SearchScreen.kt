package com.example.hard_mad_2.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.hard_mad_2.R
import com.example.hard_mad_2.models.SearchBlockType

@Composable
fun SearchScreenContent() {
    val scrollState = rememberLazyGridState()
    val scrollOffset = scrollState.firstVisibleItemScrollOffset.toFloat()

    val searchBarAlpha by animateFloatAsState(
        targetValue = if (scrollOffset > 0) 0f else 1f,
        animationSpec = tween(durationMillis = 800)
    )
    val searchBarTranslationY by animateFloatAsState(
        targetValue = if (scrollOffset > 0) -scrollOffset else 0f,
        animationSpec = tween(durationMillis = 200),
    )

    Box(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            state = scrollState,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp)
                .background(color = MaterialTheme.colorScheme.background),
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                Spacer(Modifier.height(120.dp))
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 8.dp),
                    text = stringResource(R.string.recent_requests),
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            items(listOf("iOS"), span = { GridItemSpan(maxLineSpan) }) { item ->
                SearchScreenGridItem(item, SearchBlockType.RECENT_REQUEST)
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp, top = 16.dp),
                    text = stringResource(R.string.genres_header),
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            items(
                listOf(
                    "Классика",
                    "Фэнтези",
                    "Фантастика",
                    "Детектив",
                    "Триллер",
                    "Исторический роман",
                    "Любовный роман",
                    "Приключения"
                )
            ) { item ->
                SearchScreenGridItem(item, SearchBlockType.GENRE)
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp, top = 16.dp),
                    text = stringResource(R.string.authors),
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            items(
                listOf(
                    "Классика",
                    "Фэнтези",
                    "Фантастика",
                    "Детектив",
                    "Триллер",
                    "Исторический роман",
                    "Любовный роман",
                    "Приключения"
                ), span = { GridItemSpan(maxLineSpan) }
            ) { item ->
                SearchScreenGridItem(item, SearchBlockType.AUTHORS)
            }
        }

        if (searchBarAlpha != 0f) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .graphicsLayer {
                        alpha = searchBarAlpha
                        translationY = searchBarTranslationY
                    }
            ) {
                com.example.hard_mad_2.components.search_screen.SearchBar()
            }
        }
    }
}

@Composable
fun SearchScreenGridItem(text: String, type: SearchBlockType) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.onPrimaryContainer
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            when (type) {
                SearchBlockType.RECENT_REQUEST -> {
                    Icon(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(end = 8.dp),
                        painter = painterResource(R.drawable.history_icon),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }

                SearchBlockType.GENRE -> {}
                SearchBlockType.AUTHORS -> {}
            }
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
        if (type == SearchBlockType.RECENT_REQUEST) {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.CenterEnd)
            ) {
                Icon(
                    modifier = Modifier
                        .wrapContentSize(),
                    painter = painterResource(R.drawable.close_icon),
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = null
                )
            }
        }
    }
}

