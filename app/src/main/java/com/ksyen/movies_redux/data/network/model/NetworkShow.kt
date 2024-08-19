package com.ksyen.movies_redux.data.network.model

import com.google.gson.annotations.SerializedName
import com.ksyen.movies_redux.domain.model.Show

data class NetworkShow(
    val id: Int,
    val name: String,
    val overview: String,
    @SerializedName("vote_average") val vote: Double,
    @SerializedName("poster_path") val poster: String
)

fun NetworkShow.convertToShow(): Show =
    Show(id = id, name = name, overview = overview, vote = vote, poster = poster)
