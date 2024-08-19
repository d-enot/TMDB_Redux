package com.ksyen.movies_redux.redux

fun appReducer(state: AppState, action: Any): AppState {
    return state.copy(
        onAirShowsState = onAirShowsReducer(state.onAirShowsState, action = action as ShowsActions),
        popularShowsState = popularShowsReducer(state.popularShowsState, action = action as ShowsActions)
    )
}