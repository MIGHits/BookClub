package com.example.hard_mad_2.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import com.example.hard_mad_2.components.BottomSpacer
import com.example.hard_mad_2.components.reading_screen.BottomBar
import com.example.hard_mad_2.components.reading_screen.TopBar
import com.example.hard_mad_2.components.reading_screen.settings_sheet.SettingBottomSheet
import com.example.hard_mad_2.components.reading_screen.side_menu.BookContentMenu
import kotlinx.coroutines.delay

@Composable
fun ChapterScreenContent() {
    var isBookMenuOpen by remember { mutableStateOf(false) }
    var showBottomSheet by remember { mutableStateOf(false) }

    var currentSentenceIndex by remember { mutableIntStateOf(-1) }
    val lazyListState = rememberLazyListState()
    var isPlaying by remember { mutableStateOf(false) }
    var isUserScrolling by remember { mutableStateOf(false) }

    val text = "Париж, Лувр\u202821.46\n" +
            "Знаменитый куратор Жак Соньер, пошатыва\u0002ясь, прошел под сводчатой аркой Большой га\u0002лереи и устремился к первой попавшейся ему" +
            "на глаза картине, полотну Караваджо. Ухватил\u0002ся руками за позолоченную раму и стал тянуть" +
            "ее на себя, пока шедевр не сорвался со стены и" +
            "не рухнул на семидесятилетнего старика Соньера, погребя его под собой.\n" +
            "Как и предполагал Соньер, неподалеку с грохотом опустилась" +
            "металлическая решетка, преграждающая доступ в этот зал. Пар\u0002кетный пол содрогнулся. Где-то завыла сирена игнализации.\n" +
            "Несколько секунд куратор лежал неподвижно, хватая ртом" +
            "воздух и пытаясь сообразить, на каком свете находится. Я все еще жив. Потом он выполз из-под полотна и начал судорожно ози\u0002раться в поисках места, где можно спрятаться.\n" +
            "Голос прозвучал неожиданно близко:\n" +
            "— Не двигаться.\n" +
            "Стоявший на четвереньках куратор похолодел, потом медлен\u0002но обернулся. Всего в пятнадцати футах от него, за решеткой, высилась внушительная и грозная фигура его преследователя. Вы\u0002сокий, широкоплечий, с мертвенно-бледной кожей и редкими\n" +
            "белыми волосами. Белки розовые, а зрачки угрожающего темно\u0002красного цвета. Альбинос достал из кармана пистолет, сунул\n" +
            "длинный ствол в отверстие между железными прутьями и при\u0002целился в куратора.\n"

    val paragraphs = text.split("\n").map { it.trim() }
    val sentences = mutableListOf<String>()

    paragraphs.map { paragraph ->
        sentences.addAll(paragraph.split(Regex("(?<=[.!?])\\s+"))
            .map { it.trim() })
    }


    val baseSpeed = 30L

    LaunchedEffect(isPlaying) {
        if (isPlaying) {
            for (i in sentences.indices) {
                if (!isPlaying) break
                if (isUserScrolling) {
                    while (isUserScrolling) {
                        delay(300)
                    }
                }

                currentSentenceIndex = i
                lazyListState.animateScrollToItem(i, scrollOffset = -75)

                val sentenceLength = sentences[i].length
                val sentenceDelay = sentenceLength * baseSpeed
                delay(sentenceDelay)
            }
            isPlaying = false
        }
    }

    LaunchedEffect(lazyListState) {
        snapshotFlow { lazyListState.isScrollInProgress }
            .collect { isScrolling ->
                if (isScrolling) {
                    isUserScrolling = true
                } else {
                    delay(1500)
                    isUserScrolling = false
                }
            }
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Scaffold(
            topBar = {
                TopBar(bookName = "КОД ДА ВИНЧИ", chapter = "Пролог", backAction = {})
            },
            bottomBar = {
                BottomBar(
                    bookMenuAction = { isBookMenuOpen = !isBookMenuOpen },
                    showBottomSheet = { showBottomSheet = !showBottomSheet },
                    play = { isPlaying = !isPlaying },
                    isPlaying
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = paddingValues.calculateTopPadding(),
                        bottom = paddingValues.calculateTopPadding(),
                        start = 16.dp,
                        end = 16.dp
                    )
            ) {
                LazyColumn(
                    state = lazyListState
                ) {
                    items(sentences.size) { index ->
                        val sentence = sentences[index]
                        val isCurrent = index == currentSentenceIndex

                        val textColor by animateColorAsState(
                            targetValue = if (isCurrent) Color.Red else MaterialTheme.colorScheme.primary,
                            animationSpec = tween(durationMillis = 700)
                        )

                        val annotatedString = buildAnnotatedString {
                            append(sentence)
                            if (isCurrent) {
                                addStyle(
                                    style = SpanStyle(color = Color.Red),
                                    start = 0,
                                    end = sentence.length
                                )
                            }
                        }

                        Text(
                            text = annotatedString,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            color = textColor
                        )
                    }
                    item {
                        BottomSpacer(64)
                    }
                }
                val firstVisibleItem = lazyListState.layoutInfo.visibleItemsInfo.firstOrNull()
                val isFirstItemFullyVisible = firstVisibleItem?.let {
                    it.index == 0 && it.offset == 0 && it.size == it.offset + it.size
                } ?: false

                if (!isFirstItemFullyVisible) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.1f)
                            .align(Alignment.TopStart)
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        MaterialTheme.colorScheme.background,
                                        MaterialTheme.colorScheme.background.copy(alpha = 0f),
                                    ),
                                    startY = 0f,
                                    endY = Float.POSITIVE_INFINITY
                                )
                            )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.1f)
                        .align(Alignment.BottomStart)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.background.copy(alpha = 0f),
                                    MaterialTheme.colorScheme.background,
                                ),
                                startY = 0f,
                                endY = Float.POSITIVE_INFINITY
                            )
                        )
                )
            }
        }
    }
    AnimatedVisibility(
        visible = isBookMenuOpen,
        enter = slideInHorizontally(initialOffsetX = { fullWidth -> fullWidth / 2 }),
        exit = slideOutHorizontally(targetOffsetX = { fullWidth -> fullWidth }),
        modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars)
    ) {
        BookContentMenu(modifier = Modifier, current = 0) { isBookMenuOpen = false }
    }
    AnimatedVisibility(
        visible = showBottomSheet,
        enter = slideInVertically(initialOffsetY = { fullHeight -> fullHeight / 2 }),
        exit = slideOutVertically(targetOffsetY = { fullHeight -> fullHeight })
    ) {
        SettingBottomSheet(Modifier, 1, 1, { showBottomSheet = false })
    }
}






