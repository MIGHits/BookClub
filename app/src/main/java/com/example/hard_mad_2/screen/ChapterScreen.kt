package com.example.hard_mad_2.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import com.example.hard_mad_2.components.reading_screen.AutoScroll
import com.example.hard_mad_2.components.reading_screen.ChapterContentList
import com.example.hard_mad_2.components.reading_screen.ChapterScaffold
import com.example.hard_mad_2.components.reading_screen.settings_sheet.SettingBottomSheet
import com.example.hard_mad_2.components.reading_screen.side_menu.BookContentMenu
import com.example.hard_mad_2.models.ChapterContent

@Composable
fun ChapterScreenContent(
    backAction: () -> Unit,
    bookName: String,
    currentChapter: Int,
    chapterContent: List<ChapterContent>
) {
    var isBookMenuOpen by remember { mutableStateOf(false) }
    var showBottomSheet by remember { mutableStateOf(false) }
    var chapterNumber by remember { mutableIntStateOf(currentChapter) }
    var currentSentenceIndex by remember { mutableIntStateOf(-1) }
    val lazyListState = rememberLazyListState()
    var isPlaying by remember { mutableStateOf(false) }
    var isUserScrolling by remember { mutableStateOf(false) }
    var textSize by remember { mutableIntStateOf(14) }
    var lineHeight by remember { mutableIntStateOf(21) }
    val sentences = extractSentences(chapterContent[chapterNumber].content)

    AutoScroll(isPlaying,
        isUserScrolling = isUserScrolling,
        sentences = sentences,
        lazyListState = lazyListState,
        updateIndex = { index ->
            currentSentenceIndex = index
        }, stop = { isPlaying = false })

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ChapterScaffold(
            bookName, chapterContent[chapterNumber].name, backAction,
            { isBookMenuOpen = !isBookMenuOpen }, { showBottomSheet = !showBottomSheet },
            { isPlaying = !isPlaying }, isPlaying,
            {
                if (chapterNumber != chapterContent.size - 1) {
                    chapterNumber++
                    isPlaying = false
                    currentSentenceIndex = -1
                }
            },
            {
                if (chapterNumber != 0) {
                    chapterNumber--
                    isPlaying = false
                    currentSentenceIndex = -1
                }
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = paddingValues.calculateTopPadding(),
                        bottom = paddingValues.calculateTopPadding(),
                        start = 16.dp,
                        end = 16.dp
                    )
            ) {
                ChapterContentList(
                    sentences, lazyListState, currentSentenceIndex, textSize, lineHeight
                )

                val firstVisibleItem = lazyListState.layoutInfo.visibleItemsInfo.firstOrNull()
                val isFirstItemFullyVisible = firstVisibleItem?.let {
                    it.index == 0 && it.offset == 0 && it.size == it.offset + it.size
                } ?: false

                if (!isFirstItemFullyVisible) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.1f)
                            .align(Alignment.TopStart)
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        MaterialTheme.colorScheme.background,
                                        MaterialTheme.colorScheme.background.copy(alpha = 0f),
                                    ),
                                    startY = 0f,
                                    endY = Float.POSITIVE_INFINITY
                                )
                            )
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.1f)
                        .align(Alignment.BottomStart)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.background.copy(alpha = 0f),
                                    MaterialTheme.colorScheme.background,
                                ),
                                startY = 0f,
                                endY = Float.POSITIVE_INFINITY
                            )
                        )
                )
            }
        }
    }


    AnimatedVisibility(
        visible = isBookMenuOpen,
        enter = slideInHorizontally(
            initialOffsetX = { fullWidth -> fullWidth },
            animationSpec = tween(durationMillis = 300, easing = FastOutLinearInEasing)
        ),
        exit = slideOutHorizontally(
            targetOffsetX = { fullWidth -> fullWidth },
            animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
        )
    ) {
        BookContentMenu(
            modifier = Modifier,
            current = chapterNumber,
            bookContent = chapterContent.map { it.name },
            hideMenu = { isBookMenuOpen = false }
        )
    }



    AnimatedVisibility(
        visible = showBottomSheet,
        enter = slideInVertically(
            initialOffsetY = { fullHeight -> fullHeight / 2 },
            animationSpec = tween(durationMillis = 300, easing = FastOutLinearInEasing)
        ),
        exit = slideOutVertically(
            targetOffsetY = { fullHeight -> fullHeight },
            animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
        )
    ) {
        SettingBottomSheet(
            Modifier, textSize, lineHeight,
            { showBottomSheet = false },
            { textSize = it },
            { lineHeight = it }
        )
    }

}


fun extractSentences(content: String): List<String> {
    return content.split("\n").flatMap { it.split(Regex("(?<=[.!?])\\s+")) }.map { it.trim() }
}








