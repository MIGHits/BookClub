package com.example.hard_mad_2.state

data class ReadingState(
    val isReading: Boolean = false,
    val chapter: String = "",
    val progress: Int = 0
)
