package com.example.hard_mad_2.components.reading_screen.settings_sheet

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.hard_mad_2.R

@Composable
fun SettingBottomSheet(
    modifier: Modifier = Modifier,
    selectedSize: Int,
    selectedHeight: Int,
    hideSheet: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clickable(
                onClick = { hideSheet() },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .fillMaxHeight(272 / 816f)
                .background(
                    color = MaterialTheme.colorScheme.background,
                    shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)
                )
                .shadow(
                    elevation = 1.dp,
                    shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
                    clip = true
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val sizeSliderIndex = rememberSaveable { mutableFloatStateOf(0f) }
            val interactionSource = remember { MutableInteractionSource() }

            val lineHeightSliderIndex = rememberSaveable { mutableFloatStateOf(0f) }
            val lineHeightInteractionSource = remember { MutableInteractionSource() }

            BottomSheetHeader(onCloseAction = hideSheet)
            SettingsSlider(
                modifier = Modifier,
                sliderIndex = sizeSliderIndex,
                onValueChange = { value -> sizeSliderIndex.floatValue = value },
                interactionSource = interactionSource,
                headerText = stringResource(R.string.font_size_header)
            )
            SettingsSlider(
                modifier = Modifier.padding(top = 27.dp),
                sliderIndex = lineHeightSliderIndex,
                onValueChange = { value -> lineHeightSliderIndex.floatValue = value },
                interactionSource = lineHeightInteractionSource,
                headerText = stringResource(R.string.line_height_size)
            )
        }
    }
}