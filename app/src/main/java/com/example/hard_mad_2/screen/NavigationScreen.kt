package com.example.hard_mad_2.screen

//noinspection UsingMaterialAndMaterial3Libraries
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hard_mad_2.R
import com.example.hard_mad_2.common.Constant.HEADLINE_LARGE_SIZE
import com.example.hard_mad_2.common.Constant.LARGE_BUTTON
import com.example.hard_mad_2.common.Constant.SMALL_BUTTON
import com.example.hard_mad_2.common.Constant.SMALL_HEIGHT
import com.example.hard_mad_2.common.Constant.SMALL_WIDTH
import com.example.hard_mad_2.common.Constant.TITLE_LARGE_SIZE
import com.example.hard_mad_2.components.BottomNavigationBar
import com.example.hard_mad_2.screen.routes.BookDetails
import com.example.hard_mad_2.screen.routes.BookmarksScreen
import com.example.hard_mad_2.screen.routes.ChapterScreen
import com.example.hard_mad_2.screen.routes.LibraryScreen
import com.example.hard_mad_2.screen.routes.SearchScreen
import com.example.hard_mad_2.screen.routes.SignInScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavigationScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    val playButtonSize =
        if (screenWidth < SMALL_WIDTH || screenHeight < SMALL_HEIGHT) SMALL_BUTTON.dp else
            LARGE_BUTTON.dp

    var bottomBarVisible by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
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
            startDestination = ChapterScreen.toString(),
            modifier = modifier.fillMaxSize()
        ) {
            composable(SignInScreen.toString()) {
                bottomBarVisible = false
                SignInScreenContent()
            }
            composable(LibraryScreen.toString()) {
                bottomBarVisible = true
                LibraryScreenContent()
            }
            composable(SearchScreen.toString()) {
                bottomBarVisible = true
                SearchScreenContent()
            }
            composable(BookmarksScreen.toString()) {
                bottomBarVisible = true
                BookmarksScreenContent()
            }
            composable(BookDetails.toString()) {
                bottomBarVisible = false
                BookDetailsContent()
            }
            composable(ChapterScreen.toString()) {
                bottomBarVisible = false
                ChapterScreenContent()
            }
        }
        if (bottomBarVisible) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 40.dp)
                    .align(Alignment.BottomCenter),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
                shape = RoundedCornerShape(50)
            ) {
                BottomNavigationBar(
                    navController
                )
            }
            FloatingActionButton(
                onClick = {},
                modifier = Modifier
                    .padding(bottom = 34.dp)
                    .align(Alignment.BottomCenter)
                    .size(playButtonSize),
                shape = CircleShape,
                backgroundColor = MaterialTheme.colorScheme.secondary
            ) {
                Icon(
                    painter = painterResource(R.drawable.play_icon),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}
