package com.example.hard_mad_2.components.reading_screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ChapterScaffold(
    bookName: String,
    chapterTitle: String,
    backAction: () -> Unit,
    bookMenuAction: () -> Unit,
    showBottomSheet: () -> Unit,
    playAction: () -> Unit,
    isPlaying: Boolean,
    nextChapter: () -> Unit,
    previousChapter: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = Modifier,
        topBar = { TopBar(bookName, chapterTitle, backAction) },
        bottomBar = {
            BottomBar(
                bookMenuAction,
                showBottomSheet,
                playAction,
                isPlaying = isPlaying,
                nextChapter = nextChapter,
                previousChapter = previousChapter
            )
        },
        content = content
    )
}