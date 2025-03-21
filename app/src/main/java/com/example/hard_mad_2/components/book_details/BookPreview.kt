package com.example.hard_mad_2.components.book_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.hard_mad_2.R
import com.example.hard_mad_2.data_stub.Data

@Composable
fun BookPreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.084f)
    ) {
        AsyncImage(
            model = Data.bookDetailsPreview,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .align(Alignment.BottomStart)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.background.copy(alpha = 0f),
                            MaterialTheme.colorScheme.background
                        ),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        )
        FloatingActionButton(
            onClick = {},
            backgroundColor = MaterialTheme.colorScheme.primary,
            modifier =
            Modifier
                .padding(top = 72.dp, start = 20.dp)
                .fillMaxSize(0.12f)
                .aspectRatio(1f),
            shape = CircleShape
        ) {
            Icon(
                painter = painterResource(R.drawable.back_icon),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onBackground,
            )
        }
    }
}