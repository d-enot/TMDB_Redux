package com.ksyen.movies_redux.data.network

import com.ksyen.movies_redux.BuildConfig
import com.ksyen.movies_redux.data.network.model.convertToShow
import com.ksyen.movies_redux.domain.model.Show
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ShowsNetworkDataSource @Inject constructor(
    private val showsApi: ShowsApi,
    private val coroutineScope: CoroutineContext
) {
    suspend fun getOnAirShows(): List<Show> = withContext(coroutineScope) {
        val token: String = BuildConfig.TMDB_KEY
        val result = showsApi.getOnAirShows(token = token, language = "en-US", page = 1)
        result.results.map { item ->
            item.convertToShow()
        }
    }

    suspend fun getPopularShows(): List<Show> = withContext(coroutineScope) {
        val token: String = BuildConfig.TMDB_KEY
        val result = showsApi.getPopularShows(token = token, language = "en-US", page = 1)
        result.results.map { item ->
            item.convertToShow()
        }
    }
}