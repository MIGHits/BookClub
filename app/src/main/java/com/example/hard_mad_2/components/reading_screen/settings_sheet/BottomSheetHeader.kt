package com.example.hard_mad_2.components.reading_screen.settings_sheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.hard_mad_2.R

@Composable
fun BottomSheetHeader(onCloseAction: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 28.dp),
            text = stringResource(R.string.settings_header),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
        IconButton(
            onClick = { onCloseAction() }, modifier = Modifier
                .fillMaxSize(0.2f)
                .aspectRatio(1f)
                .padding(end = 8.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.close_icon),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}