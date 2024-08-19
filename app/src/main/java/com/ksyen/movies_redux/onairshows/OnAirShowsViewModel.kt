package com.ksyen.movies_redux.onairshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ksyen.movies_redux.redux.OnAirShowsState
import com.ksyen.movies_redux.redux.ShowsActions
import com.ksyen.movies_redux.redux.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnAirShowsViewModel @Inject constructor(
    private val store: Store<OnAirShowsState, ShowsActions>
) : ViewModel() {

    val state: StateFlow<OnAirShowsState>
        get() = store.stateFlow

    fun sendAction(actions: ShowsActions) {
        viewModelScope.launch {
            store.dispatch(ShowsActions.LoadItems)
        }
    }
}