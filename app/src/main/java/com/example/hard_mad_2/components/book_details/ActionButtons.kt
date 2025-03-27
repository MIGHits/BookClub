package com.example.hard_mad_2.components.book_details

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.hard_mad_2.R

@Composable
fun ActionButtons(readAction: () -> Unit, favoriteAction: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .offset(y = (-24).dp),
    ) {
        Button(
            modifier = Modifier.weight(0.552f),
            onClick = { readAction() },
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            contentPadding = PaddingValues(
                top = 15.dp,
                bottom = 15.dp
            )
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(18.dp),
                painter = painterResource(R.drawable.play_icon),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = stringResource(R.string.read_book),
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Spacer(Modifier.width(8.dp))
        Button(
            modifier = Modifier.weight(0.426f),
            onClick = { favoriteAction() },
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimaryContainer),
            contentPadding = PaddingValues(
                top = 15.dp,
                bottom = 15.dp
            )
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(18.dp),
                painter = painterResource(R.drawable.bookmarks_icon),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
            Text(
                text = stringResource(R.string.add_favorite),
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}