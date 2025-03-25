package com.example.hard_mad_2.components.reading_screen

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.hard_mad_2.common.Constant.BASE_SPEED
import kotlinx.coroutines.delay

@Composable
fun AutoScroll(
    isPlaying: Boolean,
    isUserScrolling: Boolean,
    sentences: List<String>,
    lazyListState: LazyListState,
    updateIndex: (Int) -> Unit,
    stop: () -> Unit
) {
    LaunchedEffect(isPlaying) {
        if (isPlaying) {
            for (i in 0 until sentences.size) {
                if (!isPlaying) break
                if (isUserScrolling) while (isUserScrolling) delay(300)
                updateIndex(i)
                lazyListState.animateScrollToItem(i, scrollOffset = -75)
                delay(sentences[i].length * BASE_SPEED)
            }
            stop()
            updateIndex(-1)
        }
    }
}