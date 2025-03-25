package com.example.hard_mad_2.components.reading_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.hard_mad_2.R

@Composable
fun TopBar(bookName: String, chapter: String, backAction: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        FloatingActionButton(
            onClick = { backAction() },
            backgroundColor = MaterialTheme.colorScheme.primary,
            modifier =
            Modifier
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
        Column(
            modifier = Modifier.weight(0.663f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = bookName,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = chapter,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
        Spacer(
            modifier = Modifier
                .weight(0.12f)
                .aspectRatio(1f)
        )
    }
}