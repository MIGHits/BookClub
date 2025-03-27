package com.example.hard_mad_2.components.book_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.hard_mad_2.R
import com.example.hard_mad_2.models.BookChapter
import com.example.hard_mad_2.models.ChapterStatus

@Composable
fun BookPart(bookChapter: BookChapter) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = bookChapter.name,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = when (bookChapter.chapterStatus) {
                ChapterStatus.READING_NOW -> FontWeight.Bold
                else -> FontWeight.Normal
            }
        )
        when (bookChapter.chapterStatus) {
            ChapterStatus.NOT_STARTED -> {}
            else -> Icon(
                painter = if (bookChapter.chapterStatus == ChapterStatus.ALREADY_READ) {
                    painterResource(
                        R.drawable.read_icon
                    )
                } else painterResource(
                    R.drawable.reading_now_icon
                ),
                contentDescription = null,
                tint = if (bookChapter.chapterStatus == ChapterStatus.ALREADY_READ) {
                    MaterialTheme.colorScheme.onPrimary
                } else MaterialTheme.colorScheme.primary
            )
        }
    }
}