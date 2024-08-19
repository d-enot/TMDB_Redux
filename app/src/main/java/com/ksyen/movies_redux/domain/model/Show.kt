package com.ksyen.movies_redux.domain.model

data class Show(
    val id: Int,
    val name: String,
    val overview: String,
    val vote: Double,
    val poster: String
)
