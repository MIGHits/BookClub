package com.example.hard_mad_2.components.search_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.hard_mad_2.R
import com.example.hard_mad_2.models.SearchBlockType

@Composable
fun BlockInfoRow(type: SearchBlockType, text: String, authorImg: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding()
    ) {
        when (type) {
            SearchBlockType.RECENT_REQUEST -> {
                Icon(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 16.dp, top = 16.dp, bottom = 16.dp, end = 8.dp),
                    painter = painterResource(R.drawable.history_icon),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            SearchBlockType.GENRE -> {}
            SearchBlockType.AUTHORS -> {
                AsyncImage(
                    model = authorImg,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .weight(0.16f)
                        .padding(start = 16.dp, top = 12.dp, bottom = 12.dp, end = 8.dp)
                        .aspectRatio(1f)
                        .clip(CircleShape),
                    contentDescription = null
                )
            }

            SearchBlockType.QUOTES -> {}
        }
        if (type == SearchBlockType.QUOTES) {
            Column(
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 12.dp,
                    top = 12.dp
                )
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = text,
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Код да Винчи • Дэн Браун",
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        } else {
            Text(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(0.76f),
                text = text,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}