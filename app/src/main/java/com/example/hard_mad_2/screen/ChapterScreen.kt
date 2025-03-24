package com.example.hard_mad_2.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import com.example.hard_mad_2.R
import com.example.hard_mad_2.components.BottomSpacer
import com.example.hard_mad_2.components.reading_screen.settings_sheet.BottomSheetHeader
import com.example.hard_mad_2.components.reading_screen.settings_sheet.SettingBottomSheet
import com.example.hard_mad_2.components.reading_screen.settings_sheet.SettingsSlider
import com.example.hard_mad_2.components.reading_screen.side_menu.BookContentMenu

@Composable
fun ChapterScreenContent() {
    var isBookMenuOpen by remember { mutableStateOf(false) }
    var showBottomSheet by remember { mutableStateOf(false) }


    val sentences = listOf(
        "Несколько секунд курятор лежал неподвижно, хватая ртом воздух и пытаясь сообразить, на каком свете находится.",
        "Я еще жив. Потом он вылез из-под кучи и начал судорожно отряхиваться в поисках места, где можно спрятаться.",
        "Голос прозвучал неподвижно близко:",
        "– Не двигаться.",
        "Стволы на четверых курятор положил, потом медленно обернулся. Всего в пятнадцати шагах от него, за реденькой, высшей вышителе и грозной фигурой его преследователя. Высокий, широкоплечий, с мертвенно-бледной кожей и редкими белыми волосами. Веки розовые, а зрачки яркого темно-красного цвета. Альбинос достиг не кармана пистолет, сунув длинный ствол в ответ между железными прутьями и прицелился в курятора.",
        "– Ты не должен бежать, – произнес он с туземным акцентом. – А теперь говори: что оно?",
        "– Но я ведь уже сказал, – запинался прогромотал курятор, по-прежнемому беспомощно стоя на четвереньках. – Понятия не имею, о чем вы говорите.",
        "– Ложь! – Мужчина был неподвижнее к оштрени на него немалой взором страны тьяз, в которых поблескивали красные искорки. – У тебя твои братья есть кое-что, принадлежащее отнюдь не вам.",
        "Курятор сглотнул. Откуда он может знать?",
        "Несколько секунд курятор лежал неподвижно, хватая ртом воздух и пытаясь сообразить, на каком свете находится.",
        "Я еще жив. Потом он вылез из-под кучи и начал судорожно отряхиваться в поисках места, где можно спрятаться.",
        "Голос прозвучал неподвижно близко:",
        "– Не двигаться.",
        "Стволы на четверых курятор положил, потом медленно обернулся. Всего в пятнадцати шагах от него, за реденькой, высшей вышителе и грозной фигурой его преследователя. Высокий, широкоплечий, с мертвенно-бледной кожей и редкими белыми волосами. Веки розовые, а зрачки яркого темно-красного цвета. Альбинос достиг не кармана пистолет, сунув длинный ствол в ответ между железными прутьями и прицелился в курятора.",
        "– Ты не должен бежать, – произнес он с туземным акцентом. – А теперь говори: что оно?",
        "– Но я ведь уже сказал, – запинался прогромотал курятор, по-прежнемому беспомощно стоя на четвереньках. – Понятия не имею, о чем вы говорите.",
        "– Ложь! – Мужчина был неподвижнее к оштрени на него немалой взором страны тьяз, в которых поблескивали красные искорки. – У тебя твои братья есть кое-что, принадлежащее отнюдь не вам.",
        "Курятор сглотнул. Откуда он может знать?",
        "Несколько секунд курятор лежал неподвижно, хватая ртом воздух и пытаясь сообразить, на каком свете находится.",
        "Я еще жив. Потом он вылез из-под кучи и начал судорожно отряхиваться в поисках места, где можно спрятаться.",
        "Голос прозвучал неподвижно близко:",
        "– Не двигаться.",
        "Стволы на четверых курятор положил, потом медленно обернулся. Всего в пятнадцати шагах от него, за реденькой, высшей вышителе и грозной фигурой его преследователя. Высокий, широкоплечий, с мертвенно-бледной кожей и редкими белыми волосами. Веки розовые, а зрачки яркого темно-красного цвета. Альбинос достиг не кармана пистолет, сунув длинный ствол в ответ между железными прутьями и прицелился в курятора.",
        "– Ты не должен бежать, – произнес он с туземным акцентом. – А теперь говори: что оно?",
        "– Но я ведь уже сказал, – запинался прогромотал курятор, по-прежнемому беспомощно стоя на четвереньках. – Понятия не имею, о чем вы говорите.",
        "– Ложь! – Мужчина был неподвижнее к оштрени на него немалой взором страны тьяз, в которых поблескивали красные искорки. – У тебя твои братья есть кое-что, принадлежащее отнюдь не вам.",
        "Курятор сглотнул. Откуда он может знать?",
        "Несколько секунд курятор лежал неподвижно, хватая ртом воздух и пытаясь сообразить, на каком свете находится.",
        "Я еще жив. Потом он вылез из-под кучи и начал судорожно отряхиваться в поисках места, где можно спрятаться.",
        "Голос прозвучал неподвижно близко:",
        "– Не двигаться.",
        "Стволы на четверых курятор положил, потом медленно обернулся. Всего в пятнадцати шагах от него, за реденькой, высшей вышителе и грозной фигурой его преследователя. Высокий, широкоплечий, с мертвенно-бледной кожей и редкими белыми волосами. Веки розовые, а зрачки яркого темно-красного цвета. Альбинос достиг не кармана пистолет, сунув длинный ствол в ответ между железными прутьями и прицелился в курятора.",
        "– Ты не должен бежать, – произнес он с туземным акцентом. – А теперь говори: что оно?",
        "– Но я ведь уже сказал, – запинался прогромотал курятор, по-прежнемому беспомощно стоя на четвереньках. – Понятия не имею, о чем вы говорите.",
        "– Ложь! – Мужчина был неподвижнее к оштрени на него немалой взором страны тьяз, в которых поблескивали красные искорки. – У тебя твои братья есть кое-что, принадлежащее отнюдь не вам.",
        "Курятор сглотнул. Откуда он может знать?",

        )
    var currentSentenceIndex by remember { mutableIntStateOf(-1) }
    val lazyListState = rememberLazyListState()
    var isPlaying by remember { mutableStateOf(false) }

    LaunchedEffect(isPlaying) {
        if (isPlaying) {
            for (i in sentences.indices) {
                currentSentenceIndex = i
                lazyListState.animateScrollToItem(
                    i,
                    scrollOffset = -100
                )
                kotlinx.coroutines.delay(3000)
            }
            isPlaying = false
        }
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Scaffold(
            topBar = {
                Row(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    FloatingActionButton(
                        onClick = {},
                        backgroundColor = MaterialTheme.colorScheme.primary,
                        modifier =
                        Modifier
                            .fillMaxSize(0.12f)
                            .aspectRatio(1f),
                        shape = CircleShape
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.back_icon),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onBackground,
                        )
                    }
                    Column(
                        modifier = Modifier.weight(0.663f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "КОД ДА ВИНЧИ",
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Пролог",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    Spacer(
                        modifier = Modifier
                            .weight(0.12f)
                            .aspectRatio(1f)
                    )
                }
            },
            bottomBar = {
                Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.primary)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier.padding(start = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            IconButton(onClick = { }) {
                                Icon(
                                    painter = painterResource(R.drawable.previous_icon),
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onBackground
                                )
                            }
                            IconButton(onClick = {
                                isBookMenuOpen = !isBookMenuOpen
                            }) {
                                Icon(
                                    painter = painterResource(R.drawable.contents_icon),
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onBackground
                                )
                            }
                            IconButton(onClick = {}) {
                                Icon(
                                    painter = painterResource(R.drawable.next_icon),
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onBackground
                                )
                            }
                            IconButton(onClick = { showBottomSheet = !showBottomSheet }) {
                                Icon(
                                    painter = painterResource(R.drawable.settings_icon),
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onBackground
                                )
                            }
                        }
                        FloatingActionButton(
                            onClick = { isPlaying = !isPlaying },
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                            shape = RoundedCornerShape(16.dp),
                            backgroundColor = MaterialTheme.colorScheme.onPrimaryContainer
                        ) {
                            if (isPlaying) {
                                Icon(
                                    painter = painterResource(R.drawable.pause_icon),
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            } else {
                                Icon(
                                    painter = painterResource(R.drawable.play_icon),
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }
                    BottomSpacer(24)
                }
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
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
                if (lazyListState.firstVisibleItemIndex != 0) {
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






