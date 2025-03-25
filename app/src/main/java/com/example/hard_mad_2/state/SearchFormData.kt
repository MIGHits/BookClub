package com.example.hard_mad_2.state

import com.example.hard_mad_2.models.AuthorModel

data class SearchFormData(
    val recentRequest: List<String>,
    val genres: List<String>,
    val authors: List<AuthorModel>
)