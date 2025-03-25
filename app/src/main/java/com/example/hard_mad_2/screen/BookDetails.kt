package com.example.hard_mad_2.screen


import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.hard_mad_2.R
import com.example.hard_mad_2.components.BottomSpacer
import com.example.hard_mad_2.components.book_details.ActionButtons
import com.example.hard_mad_2.components.book_details.BookPart
import com.example.hard_mad_2.components.book_details.BookPreview
import com.example.hard_mad_2.components.book_details.BookShortInfo
import com.example.hard_mad_2.components.bookmarks_screen.BookProgressBar
import com.example.hard_mad_2.components.search_screen.SectionHeader
import com.example.hard_mad_2.data_stub.Data
import com.example.hard_mad_2.models.BookChapter
import com.example.hard_mad_2.models.SearchItem
import com.example.hard_mad_2.state.ReadingData
import kotlinx.coroutines.launch
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ExperimentalToolbarApi
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState


@OptIn(ExperimentalToolbarApi::class)
@Composable
fun BookDetailsContent(
    backAction: () -> Unit,
    bookData: ReadingData,
    book: SearchItem,
    readAction: (String, Int, String, List<BookChapter>) -> Unit,
    favoriteAction: () -> Unit
) {
    val scrollState = rememberLazyListState()
    val state = rememberCollapsingToolbarScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    CollapsingToolbarScaffold(
        modifier = Modifier,
        state = state,
        scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
        toolbar = {
            BottomSpacer(0)
            Column(
                modifier = Modifier.parallax(0.5f)
            ) {
                BookPreview(backAction, Data.bookDetailsPreview)
                ActionButtons(readAction = {}, favoriteAction = { TODO() })
            }
        },
    ) {
        LazyColumn(
            state = scrollState,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp)
                .clickable {
                    coroutineScope.launch {
                        if (state.toolbarState.progress > 0f) {
                            state.toolbarState.collapse(100)
                        } else {
                            state.toolbarState.expand(500)
                        }
                    }
                },
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            item {
                BookShortInfo(book)
            }

            item {
                SectionHeader(
                    stringResource(R.string.already_read),
                    paddingBottom = 0,
                    paddingTop = 16,
                    modifier = Modifier
                )
            }
            item {
                if (bookData.isReading) {
                    BookProgressBar(bookData.progress / 100f)
                }
            }
            item {
                SectionHeader(
                    stringResource(R.string.book_content),
                    paddingBottom = 0,
                    paddingTop = 16,
                    modifier = Modifier
                )
            }
            items(
                Data.bookChapters
            ) { item ->
                BookPart(item)
            }
        }
    }
}

