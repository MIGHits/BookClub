package com.example.hard_mad_2.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.hard_mad_2.models.BottomNavigationItem
import com.example.hard_mad_2.ui.theme.AccentDark
import com.example.hard_mad_2.ui.theme.AccentMedium
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
            .padding(start = 16.dp, end = 16.dp)
            .clip(RoundedCornerShape(50))
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        listItems.forEach { item ->
            BottomNavigationItem(
                modifier = Modifier.aspectRatio(1.05f),
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