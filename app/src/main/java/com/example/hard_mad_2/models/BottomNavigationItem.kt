package com.example.hard_mad_2.models

import androidx.compose.material3.SearchBar
import com.example.hard_mad_2.R
import com.example.hard_mad_2.screen.routes.FavoritesScreen
import com.example.hard_mad_2.screen.routes.LibraryScreen
import com.example.hard_mad_2.screen.routes.SearchScreen
import com.example.hard_mad_2.screen.routes.SignInScreen

sealed class BottomNavigationItem(val icon: Int, val route: String) {
    data object libraryScreen :
        BottomNavigationItem(icon = R.drawable.library_icon, route = LibraryScreen.toString())

    data object searchScreen : BottomNavigationItem(
        icon = R.drawable.search_icon, route = SearchScreen.toString()
    )

    data object readScreen : BottomNavigationItem(
        icon = R.drawable.play_icon, route = ""
    )

    data object favoritesScreen : BottomNavigationItem(
        icon = R.drawable.bookmarks_icon, route = FavoritesScreen.toString()
    )

    data object loginScreen : BottomNavigationItem(
        icon = R.drawable.log_out_icon, route = SignInScreen.toString()
    )
}