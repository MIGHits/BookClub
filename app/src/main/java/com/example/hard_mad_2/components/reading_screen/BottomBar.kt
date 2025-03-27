package com.example.hard_mad_2.components.reading_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.hard_mad_2.R
import com.example.hard_mad_2.components.BottomSpacer

@Composable
fun BottomBar(
    bookMenuAction: () -> Unit,
    showBottomSheet: () -> Unit,
    play: () -> Unit,
    nextChapter: () -> Unit,
    previousChapter: () -> Unit,
    isPlaying: Boolean
) {
    Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.primary)) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.padding(start = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                IconButton(onClick = { previousChapter() }) {
                    Icon(
                        painter = painterResource(R.drawable.previous_icon),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
                IconButton(onClick = {
                    bookMenuAction()
                }) {
                    Icon(
                        painter = painterResource(R.drawable.contents_icon),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
                IconButton(onClick = { nextChapter() }) {
                    Icon(
                        painter = painterResource(R.drawable.next_icon),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
                IconButton(onClick = { showBottomSheet() }) {
                    Icon(
                        painter = painterResource(R.drawable.settings_icon),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
            FloatingActionButton(
                onClick = { play() },
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                shape = RoundedCornerShape(16.dp),
                backgroundColor = MaterialTheme.colorScheme.onPrimaryContainer
            ) {
                if (isPlaying) {
                    Icon(
                        painter = painterResource(R.drawable.pause_icon),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                } else {
                    Icon(
                        painter = painterResource(R.drawable.play_icon),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
        BottomSpacer(24)
    }
}