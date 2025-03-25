package com.example.hard_mad_2.components.reading_screen.settings_sheet

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults.colors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableFloatState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.hard_mad_2.common.Constant.SMALL_HEIGHT
import com.example.hard_mad_2.common.Constant.SMALL_WIDTH

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsSlider(
    modifier: Modifier,
    sliderIndex: MutableFloatState,
    onValueChange: (Float) -> Unit,
    interactionSource: MutableInteractionSource,
    headerText: String,
    range: ClosedFloatingPointRange<Float>,
    onSelect: (Int) -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        text = headerText,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.primary
    )
    Slider(
        value = sliderIndex.floatValue,
        onValueChange = {
            onValueChange(it)
            onSelect(it.toInt())
        },
        modifier = if (screenWidth < SMALL_WIDTH || screenHeight < SMALL_HEIGHT) {
            Modifier
                .fillMaxWidth()
                .heightIn(max = 15.dp)
                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 16.dp)
        } else Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp),
        enabled = true,
        interactionSource = interactionSource,
        valueRange = range,
        steps = 9,
        thumb = {
            CustomThumb(interactionSource, Modifier, fontSize = sliderIndex.floatValue)
        },
        colors = colors(
            activeTrackColor = MaterialTheme.colorScheme.primary,
            inactiveTrackColor = MaterialTheme.colorScheme.onPrimary,
            activeTickColor = MaterialTheme.colorScheme.primary,
        )
    )
}