package com.example.hard_mad_2.components.search_screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
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
        modifier = Modifier.padding(16.dp)
    ) {
        when (type) {
            SearchBlockType.RECENT_REQUEST -> {
                Icon(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(end = 8.dp),
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
                        .padding(end = 8.dp)
                        .aspectRatio(1f)
                        .clip(CircleShape),
                    contentDescription = null
                )
            }
        }
        Text(
            modifier = Modifier.weight(0.7578f),
            text = text,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary
        )
    }
}