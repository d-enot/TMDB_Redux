package com.ksyen.movies_redux.redux

import com.ksyen.movies_redux.domain.ShowsRepository
import javax.inject.Inject

class OnAirShowsMiddleware constructor(
    private val repository: ShowsRepository
) : Middleware<OnAirShowsState, ShowsActions> {

    override suspend fun process(
        action: ShowsActions,
        currentState: OnAirShowsState,
        next: suspend (ShowsActions) -> Unit
    ) {
        when (action) {
            is ShowsActions.LoadItems -> {
                try {
                    val items = repository.getOnAirShows()
                    next(ShowsActions.ItemsLoaded(items = items))
                } catch (error: Exception) {
                    next(ShowsActions.LoadingFailed(error = error.message.toString()))
                }
            }
            else -> {
                next(action)
            }
        }
    }
}