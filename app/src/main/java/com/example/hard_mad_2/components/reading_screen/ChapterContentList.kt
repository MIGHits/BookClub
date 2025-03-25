package com.example.hard_mad_2.components.reading_screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hard_mad_2.components.BottomSpacer

@Composable
fun ChapterContentList(
    sentences: List<String>,
    lazyListState: LazyListState,
    currentSentenceIndex: Int,
    textSize: Int,
    lineHeight: Int
) {
    LazyColumn(state = lazyListState) {
        items(sentences.size) { index ->
            val sentence = sentences[index]
            val isCurrent = index == currentSentenceIndex
            val textColor by animateColorAsState(
                targetValue = if (isCurrent) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary,
                animationSpec = tween(durationMillis = 400)
            )

            val annotatedString = buildAnnotatedString {
                var isItalic = false
                var lastIndex = 0

                sentence.forEachIndexed { i, char ->
                    if (char == '*') {
                        append(sentence.substring(lastIndex, i))
                        isItalic = !isItalic
                        lastIndex = i + 1
                    }
                }

                if (lastIndex < sentence.length) {
                    pushStyle(SpanStyle(fontStyle = if (isItalic) FontStyle.Italic else FontStyle.Normal))
                    append(sentence.substring(lastIndex))
                    pop()
                }
            }

            Text(
                text = annotatedString,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                color = textColor,
                style = MaterialTheme.typography.displayMedium.copy(
                    fontSize = textSize.sp,
                    lineHeight = lineHeight.sp
                )
            )
        }
        item { BottomSpacer(64) }
    }
}