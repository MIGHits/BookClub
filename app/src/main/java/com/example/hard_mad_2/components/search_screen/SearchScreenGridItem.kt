package com.example.hard_mad_2.components.search_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.hard_mad_2.R
import com.example.hard_mad_2.models.SearchBlockType

@Composable
fun SearchScreenGridItem(text: String, type: SearchBlockType, authorImg: String = "") {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.onPrimaryContainer
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        BlockInfoRow(type = type, text = text, authorImg = authorImg)
        if (type == SearchBlockType.RECENT_REQUEST) {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.CenterEnd)
            ) {
                Icon(
                    modifier = Modifier
                        .wrapContentSize(),
                    painter = painterResource(R.drawable.close_icon),
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = null
                )
            }
        }
    }
}