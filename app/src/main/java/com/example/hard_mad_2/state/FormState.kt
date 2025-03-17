package com.example.hard_mad_2.state

data class FormState(
    val email: String = "",
    val password: String = "",
    val isValid: Boolean = false
)
