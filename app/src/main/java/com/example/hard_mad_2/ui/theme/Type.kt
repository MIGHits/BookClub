package com.example.hard_mad_2.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.hard_mad_2.R

val Alumni = FontFamily(
    Font(R.font.alumnisans_bold, FontWeight.Bold)
)

val VelaSans = FontFamily(
    Font(R.font.vela_sans_regular, FontWeight.Normal),
    Font(R.font.vela_sans_bold, FontWeight.Bold)
)

val Georgia = FontFamily(
    Font(R.font.georgia_regular, FontWeight.Normal),
    Font(R.font.georgia_italic, FontWeight.Normal, FontStyle.Italic)
)

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = Alumni,
        fontWeight = FontWeight.Bold,
        fontSize = 96.sp,
        lineHeight = 76.8.sp,
    ),
    headlineLarge = TextStyle(
        fontFamily = Alumni,
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp,
        lineHeight = 48.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = Alumni,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 24.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = VelaSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 20.8.sp
    ),
    bodySmall = TextStyle(
        fontFamily = VelaSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 18.2.sp
    ),
    displaySmall = TextStyle(
        fontFamily = VelaSans,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 13.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Georgia,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 21.sp
    ),
    displayLarge = TextStyle(
        fontFamily = Georgia,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic,
        fontSize = 16.sp,
        lineHeight = 20.8.sp
    )
)