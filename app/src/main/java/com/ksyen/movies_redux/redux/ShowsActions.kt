package com.ksyen.movies_redux.redux

import com.ksyen.movies_redux.domain.model.Show

sealed class ShowsActions {
    object LoadItems : ShowsActions()
    data class ItemsLoaded(val items: List<Show>) : ShowsActions()
    data class LoadingFailed(val error: String) : ShowsActions()
}