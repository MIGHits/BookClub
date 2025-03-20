package com.example.hard_mad_2.models

data class SearchItem(
    val img: String,
    val name: String,
    val authors: List<String>? = emptyList()
)
