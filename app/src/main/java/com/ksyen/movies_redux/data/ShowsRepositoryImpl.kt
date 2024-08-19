package com.ksyen.movies_redux.data

import com.ksyen.movies_redux.data.network.ShowsNetworkDataSource
import com.ksyen.movies_redux.domain.ShowsRepository
import com.ksyen.movies_redux.domain.model.Show
import javax.inject.Inject

class ShowsRepositoryImpl @Inject constructor(
    private val networkDataSource: ShowsNetworkDataSource
) : ShowsRepository {
    override suspend fun getOnAirShows(): List<Show> = networkDataSource.getOnAirShows()

    override suspend fun getPopularShows(): List<Show> = networkDataSource.getPopularShows()
}