package com.ksyen.movies_redux.redux

import com.ksyen.movies_redux.domain.model.Show

data class AppState(
    val onAirShowsState: OnAirShowsState = OnAirShowsState(),
    val popularShowsState: PopularShowsState = PopularShowsState()
)

data class OnAirShowsState(
    val items: List<Show> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)

data class PopularShowsState(
    val items: List<Show> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)
