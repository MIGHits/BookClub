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
    currentSentenceIndex: Int,
    onSentenceChange: (Int) -> Unit,
    onPlaybackEnd: () -> Unit
) {
    LaunchedEffect(isPlaying) {
        if (isPlaying) {
            for (i in currentSentenceIndex.coerceAtLeast(0) until sentences.size) {
                if (!isPlaying) break
                if (isUserScrolling) {
                    while (isUserScrolling) {
                        delay(300)
                    }
                }

                onSentenceChange(i)
                lazyListState.animateScrollToItem(i, scrollOffset = -75)

                val sentenceDelay = sentences[i].length * BASE_SPEED
                delay(sentenceDelay)
            }
            onPlaybackEnd()
        }
    }
}