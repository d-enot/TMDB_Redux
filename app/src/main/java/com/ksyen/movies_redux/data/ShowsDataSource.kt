package com.ksyen.movies_redux.data

import com.ksyen.movies_redux.domain.model.Show

interface ShowsDataSource {
    suspend fun getOnAirShows(): List<Show>
    suspend fun getPopularShows(): List<Show>
}