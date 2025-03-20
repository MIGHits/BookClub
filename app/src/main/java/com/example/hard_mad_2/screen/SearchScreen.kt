package com.example.hard_mad_2.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchScreenContent() {

    Column(modifier = Modifier.padding(top = 16.dp)) {
        com.example.hard_mad_2.components.search_screen.SearchBar()
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp)
                .background(color = MaterialTheme.colorScheme.background),
            columns = GridCells.Fixed(2)
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
            }
        }
    }
}

