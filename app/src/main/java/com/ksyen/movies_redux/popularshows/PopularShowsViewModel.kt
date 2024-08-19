package com.ksyen.movies_redux.popularshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ksyen.movies_redux.redux.OnAirShowsState
import com.ksyen.movies_redux.redux.PopularShowsState
import com.ksyen.movies_redux.redux.ShowsActions
import com.ksyen.movies_redux.redux.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularShowsViewModel @Inject constructor(
    private val store: Store<PopularShowsState, ShowsActions>
) : ViewModel() {

    val state: StateFlow<PopularShowsState>
        get() = store.stateFlow

    fun sendAction(actions: ShowsActions) {
        viewModelScope.launch {
            store.dispatch(ShowsActions.LoadItems)
        }
    }
}