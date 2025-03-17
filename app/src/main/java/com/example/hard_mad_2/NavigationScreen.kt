package com.example.hard_mad_2

import androidx.activity.SystemBarStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hard_mad_2.screen.SignInScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun NavigationScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.Transparent
        )
        systemUiController.setNavigationBarColor(
            color = Color.Transparent
        )
        systemUiController.isNavigationBarVisible = false
        systemUiController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }

    NavHost(
        navController = navController,
        startDestination = SignInScreen.toString(),
        modifier = modifier
    ) {
        composable(SignInScreen.toString()) {
            SignInScreen()
        }
    }

}