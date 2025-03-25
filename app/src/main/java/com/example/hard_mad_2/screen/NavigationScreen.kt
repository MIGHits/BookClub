package com.example.hard_mad_2.screen

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
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hard_mad_2.R
import com.example.hard_mad_2.common.Constant.LARGE_BUTTON
import com.example.hard_mad_2.common.Constant.SMALL_BUTTON
import com.example.hard_mad_2.common.Constant.SMALL_HEIGHT
import com.example.hard_mad_2.common.Constant.SMALL_WIDTH
import com.example.hard_mad_2.components.BottomNavigationBar
import com.example.hard_mad_2.data_stub.Data
import com.example.hard_mad_2.screen.routes.BookDetails
import com.example.hard_mad_2.screen.routes.BookmarksScreen
import com.example.hard_mad_2.screen.routes.ChapterScreen
import com.example.hard_mad_2.screen.routes.LibraryScreen
import com.example.hard_mad_2.screen.routes.SearchScreen
import com.example.hard_mad_2.screen.routes.SignInScreen
import com.example.hard_mad_2.state.SearchFormData
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.flow.MutableStateFlow

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
            startDestination = SignInScreen.toString(),
            modifier = modifier.fillMaxSize()
        ) {
            composable(SignInScreen.toString()) {
                bottomBarVisible = false
                SignInScreenContent(onSignIn = {
                    navController.navigate(LibraryScreen.toString()) {
                        popUpTo(SignInScreen.toString()) {
                            inclusive = true
                        }
                    }
                })
            }
            composable(LibraryScreen.toString()) {
                bottomBarVisible = true
                LibraryScreenContent(toBookDetails = {
                    navController.navigate(BookDetails.toString()) {
                        launchSingleTop
                    }
                })
            }
            composable(SearchScreen.toString()) {
                bottomBarVisible = true
                SearchScreenContent(
                    searchData = MutableStateFlow(
                        SearchFormData(
                            authors = Data.authors,
                            genres = Data.genres,
                            recentRequest = Data.recentRequest
                        )
                    ),
                    toBookDetails = {
                        navController.navigate(BookDetails.toString()) {
                            launchSingleTop
                        }
                    }
                )
            }
            composable(BookmarksScreen.toString()) {
                bottomBarVisible = true
                BookmarksScreenContent(
                    toBookDetails = {
                        navController.navigate(BookDetails.toString()) {
                            launchSingleTop
                        }
                    },
                    currentBook = Data.readingBook,
                    currentBookData = Data.currentBookData, toReadScreen = {
                        navController.navigate(ChapterScreen.toString()) {
                            launchSingleTop
                        }
                    })
            }
            composable(BookDetails.toString()) {
                bottomBarVisible = false
                BookDetailsContent(
                    backAction = { navController.navigateUp() },
                    bookData = Data.currentBookData,
                    book = Data.readingBook,
                    readAction = {
                        navController.navigate(ChapterScreen.toString()) {
                            launchSingleTop
                        }
                    },
                    favoriteAction = { searchItem -> Data.searchItems.add(searchItem) }
                )
            }
            composable(ChapterScreen.toString()) {
                bottomBarVisible = false
                ChapterScreenContent(
                    backAction = { navController.navigateUp() },
                    bookName = Data.readingBook.name,
                    currentChapter = 0,
                    chapterContent = Data.chapters
                )
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
                onClick = {
                    navController.navigate(ChapterScreen.toString()) {
                        launchSingleTop
                    }
                },
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
