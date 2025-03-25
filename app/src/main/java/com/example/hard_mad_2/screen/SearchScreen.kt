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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.hard_mad_2.state.SearchFormData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun SearchScreenContent(searchData: StateFlow<SearchFormData>) {
    val formState by searchData.collectAsState()

    val scrollState = rememberLazyGridState()
    val searchState = remember { mutableStateOf("") }
    val expandState = remember { mutableStateOf(false) }

    val scrollOffset = scrollState.firstVisibleItemScrollOffset.toFloat()

    val searchBarAlpha by animateFloatAsState(
        targetValue = if (scrollOffset > 0 && !expandState.value) 0f else 1f,
        animationSpec = tween(durationMillis = 800)
    )
    val searchBarTranslationY by animateFloatAsState(
        targetValue = if (scrollOffset > 0 && !expandState.value) -scrollOffset else 0f,
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
                BottomSpacer(120)
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                SectionHeader(
                    text = stringResource(R.string.recent_requests),
                    paddingBottom = 8,
                    paddingTop = 8,
                    Modifier
                )
            }
            items(formState.recentRequest, span = { GridItemSpan(maxLineSpan) }) { item ->
                SearchScreenGridItem(
                    text = item,
                    type = SearchBlockType.RECENT_REQUEST,
                    onClick = { value ->
                        searchState.value = value
                        expandState.value = true
                    }
                )
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
                formState.genres.chunked(GRID_SPAN_COUNT),
                span = { GridItemSpan(maxLineSpan) }
            ) { rowItems ->
                Genres(rowItems, onClick = { value ->
                    searchState.value = value
                    expandState.value = true
                })
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
                formState.authors, span = { GridItemSpan(maxLineSpan) }
            ) { item ->
                SearchScreenGridItem(
                    text = item.name,
                    type = SearchBlockType.AUTHORS,
                    authorImg = item.image,
                    onClick = { value ->
                        searchState.value = value
                        expandState.value = true
                    }
                )
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                BottomSpacer(100)
            }
        }

        if (searchBarAlpha != 0f || expandState.value) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .graphicsLayer {
                        alpha = searchBarAlpha
                        translationY = searchBarTranslationY
                    }
            ) {
                BookSearchBar(searchState = searchState, isExpanded = expandState)
            }
        }
    }
}

