package com.ksyen.movies_redux.domain

import com.ksyen.movies_redux.domain.model.Show

interface ShowsRepository {
    suspend fun getOnAirShows(): List<Show>
    suspend fun getPopularShows(): List<Show>
}