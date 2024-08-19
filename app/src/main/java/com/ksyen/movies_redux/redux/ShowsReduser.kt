package com.ksyen.movies_redux.redux

fun onAirShowsReducer(state: OnAirShowsState, action: ShowsActions): OnAirShowsState {
    return when (action) {
        is ShowsActions.ItemsLoaded -> state.copy(loading = false, items = action.items)
        is ShowsActions.LoadingFailed -> state.copy(loading = false, error = action.error)
        ShowsActions.LoadItems -> state.copy(loading = true)
    }
}

fun popularShowsReducer(state: PopularShowsState, action: ShowsActions): PopularShowsState {
    return when (action) {
        is ShowsActions.ItemsLoaded -> state.copy(loading = false, items = action.items)
        is ShowsActions.LoadingFailed -> state.copy(loading = false, error = action.error)
        ShowsActions.LoadItems -> state.copy(loading = true)
    }
}

