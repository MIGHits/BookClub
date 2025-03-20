package com.example.hard_mad_2.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.hard_mad_2.R
import com.example.hard_mad_2.common.Constant.GRID_SPAN_COUNT
import com.example.hard_mad_2.components.BottomSpacer
import com.example.hard_mad_2.components.search_screen.BookSearchBar
import com.example.hard_mad_2.components.search_screen.Genres
import com.example.hard_mad_2.components.search_screen.SearchScreenGridItem
import com.example.hard_mad_2.components.search_screen.SectionHeader
import com.example.hard_mad_2.data_stub.Data
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
            columns = GridCells.Fixed(GRID_SPAN_COUNT),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                BottomSpacer(104)
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                SectionHeader(
                    text = stringResource(R.string.recent_requests),
                    paddingBottom = 8,
                    paddingTop = 8,
                    Modifier
                )
            }
            items(listOf("iOS"), span = { GridItemSpan(maxLineSpan) }) { item ->
                SearchScreenGridItem(item, SearchBlockType.RECENT_REQUEST)
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                SectionHeader(
                    text = stringResource(R.string.genres_header),
                    paddingBottom = 8,
                    paddingTop = 16,
                    Modifier
                )
            }
            items(
                Data.genres.chunked(GRID_SPAN_COUNT),
                span = { GridItemSpan(maxLineSpan) }
            ) { rowItems ->
                Genres(rowItems)
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                SectionHeader(
                    text = stringResource(R.string.authors),
                    paddingBottom = 8,
                    paddingTop = 16,
                    Modifier
                )
            }
            items(
                Data.authors, span = { GridItemSpan(maxLineSpan) }
            ) { item ->
                SearchScreenGridItem(item.name, SearchBlockType.AUTHORS, item.image)
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                BottomSpacer(100)
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
                BookSearchBar()
            }
        }
    }
}

