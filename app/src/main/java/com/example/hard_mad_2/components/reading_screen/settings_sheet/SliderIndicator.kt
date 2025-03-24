package com.example.hard_mad_2.components.reading_screen.settings_sheet

import android.graphics.Typeface
import androidx.compose.foundation.background
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hard_mad_2.ui.theme.VelaSans

@Composable
fun SliderIndicator(size: DpSize, text: String) {
    val interactionSource = remember { MutableInteractionSource() }
    val circleColor = MaterialTheme.colorScheme.primary
    val textColor = MaterialTheme.colorScheme.onBackground
    val font = TextStyle(
        fontSize = 14.sp,
        fontFamily = VelaSans,
        fontWeight = FontWeight.Medium,
        lineHeight = 20.sp
    )
    Box(
        modifier = Modifier
            .size(size)
            .hoverable(interactionSource = interactionSource)
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(2.dp)
            )
            .drawBehind {
                val rectWidth = 48.dp.toPx()
                val rectHeight = 44.dp.toPx()
                val circleCenter = Offset(size.width.toPx() / 2, -rectHeight / 2 - 4.dp.toPx())

                val rectTopLeft = Offset(
                    x = size.width.toPx() / 2 - rectWidth / 2,
                    y = -rectHeight - 4.dp.toPx()
                )

                drawRoundRect(
                    color = circleColor,
                    topLeft = rectTopLeft,
                    size = Size(rectWidth, rectHeight),
                    cornerRadius = CornerRadius(100f, 100f)
                )

                drawContext.canvas.nativeCanvas.apply {
                    val textPaint = android.graphics.Paint().apply {
                        isAntiAlias = true
                        color = textColor.toArgb()
                        textSize = font.fontSize.toPx()
                        textAlign = android.graphics.Paint.Align.CENTER
                        typeface = font.fontFamily?.let { fontFamily ->
                            Typeface.create(fontFamily.toString(), Typeface.NORMAL)
                        } ?: Typeface.DEFAULT
                        if (font.fontWeight != null) {
                            typeface = Typeface.create(typeface, font.fontWeight!!.weight)
                        }
                    }

                    val x = circleCenter.x
                    val y = circleCenter.y + (textPaint.textSize / 3)

                    drawText(text, x, y, textPaint)
                }
            }
    )
}