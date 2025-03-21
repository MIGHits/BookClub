package com.example.hard_mad_2.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.FloatingActionButton
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.hard_mad_2.R
import com.example.hard_mad_2.components.BottomSpacer
import com.example.hard_mad_2.components.book_details.ActionButtons
import com.example.hard_mad_2.components.book_details.BookPreview
import com.example.hard_mad_2.components.book_details.BookShortInfo
import com.example.hard_mad_2.components.search_screen.SectionHeader
import com.example.hard_mad_2.data_stub.Data
import kotlinx.coroutines.launch
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ExperimentalToolbarApi
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState


@OptIn(ExperimentalToolbarApi::class)
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun BookDetailsContent() {
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
                BookPreview()
                ActionButtons()
            }
        },
    ) {
        LazyColumn(
            state = scrollState,
            modifier = Modifier
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
                BookShortInfo()
            }

            item {
                SectionHeader(
                    stringResource(R.string.already_read),
                    paddingBottom = 0,
                    paddingTop = 16,
                    modifier = Modifier
                )
            }
        }
    }
}
