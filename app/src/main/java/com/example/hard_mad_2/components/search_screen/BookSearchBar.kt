package com.example.hard_mad_2.components.search_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBarDefaults.InputField
import androidx.compose.material3.SearchBarDefaults.colors
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.hard_mad_2.R
import com.example.hard_mad_2.data_stub.Data
import com.example.hard_mad_2.state.ReadingData
import kotlinx.coroutines.flow.StateFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookSearchBar(searchState: MutableState<String>, isExpanded: MutableState<Boolean>) {
    var textFieldState by remember { searchState }
    var expanded by rememberSaveable { isExpanded }

    androidx.compose.material3.SearchBar(
        modifier = if (expanded) {
            Modifier
                .fillMaxWidth()
        } else {
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        },
        shape = RoundedCornerShape(28.dp),
        inputField = {
            CompositionLocalProvider(
                LocalTextStyle provides MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.primary
                )
            ) {
                InputField(
                    modifier = if (expanded) {
                        Modifier
                    } else {
                        Modifier.border(
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onPrimary),
                            shape = RoundedCornerShape(28.dp)
                        )
                    },
                    query = textFieldState,
                    onSearch = { expanded = false },
                    expanded = expanded,
                    onExpandedChange = { expanded = it },
                    placeholder = {
                        Text(
                            text = stringResource(R.string.book_search),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    },
                    leadingIcon = {
                        if (expanded) {
                            Icon(
                                painter = painterResource(R.drawable.back_icon),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.clickable {
                                    expanded = !expanded
                                }
                            )
                        } else {
                            Icon(
                                painter = painterResource(R.drawable.search_icon),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimary,
                                modifier = Modifier.padding(
                                    start = 28.dp,
                                    end = 16.dp,
                                    top = 16.dp,
                                    bottom = 16.dp
                                )
                            )
                        }
                    },
                    trailingIcon = {
                        if (expanded) {
                            Icon(
                                painter = painterResource(R.drawable.close_icon),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.clickable {
                                    textFieldState = ""
                                }
                            )
                        }
                    },
                    onQueryChange = { textFieldState = it },
                    colors = TextFieldDefaults.colors(
                        cursorColor = MaterialTheme.colorScheme.secondary,
                        focusedContainerColor = MaterialTheme.colorScheme.background,
                        unfocusedContainerColor = MaterialTheme.colorScheme.onBackground
                    ),
                )
            }
        },
        colors = colors(
            containerColor = if (expanded) {
                MaterialTheme.colorScheme.background
            } else {
                MaterialTheme.colorScheme.onBackground
            },
            dividerColor = MaterialTheme.colorScheme.onPrimary,
            inputFieldColors = TextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.primary,
                unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
                focusedContainerColor = MaterialTheme.colorScheme.background,
                focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
                focusedTrailingIconColor = MaterialTheme.colorScheme.primary,
            )
        ),
        expanded = expanded, onExpandedChange = { expanded = it },
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(Data.searchItems) { item ->
                BookElement(item, ReadingData())
            }
            item {
                Spacer(modifier = Modifier.height(95.dp))
            }
        }
    }
}