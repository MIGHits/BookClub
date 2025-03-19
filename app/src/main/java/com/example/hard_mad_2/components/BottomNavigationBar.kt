package com.example.hard_mad_2.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.hard_mad_2.models.BottomNavigationItem
import com.example.hard_mad_2.ui.theme.AccentDark
import com.example.hard_mad_2.ui.theme.AccentMedium
import com.example.hard_mad_2.ui.theme.Secondary
import com.example.hard_mad_2.ui.theme.White

@Composable
fun BottomNavigationBar(navController: NavController) {
    val listItems = listOf(
        BottomNavigationItem.libraryScreen,
        BottomNavigationItem.searchScreen,
        BottomNavigationItem.readScreen,
        BottomNavigationItem.favoritesScreen,
        BottomNavigationItem.loginScreen
    )

    BottomNavigation(
        backgroundColor = AccentDark,
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer(clip = false)
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        listItems.forEach { item ->
            BottomNavigationItem(
                modifier = if (item.route == "") {
                    Modifier
                        .drawBehind {
                            drawCircle(color = Secondary, radius = 100f)
                        }
                } else {
                    Modifier
                },
                selected = currentRoute == item.route,
                onClick = { navController.navigate(item.route) },
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = null
                    )
                },
                selectedContentColor = White,
                unselectedContentColor = if (item.route == "") {
                    White
                } else {
                    AccentMedium
                }
            )
        }
    }

}