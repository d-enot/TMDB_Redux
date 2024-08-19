package com.ksyen.movies_redux.redux

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Store<S, A>(
    initialState: S,
    private val reducer: (S, A) -> S,
    private val middlewares: List<Middleware<S, A>> = listOf(),
) {
    private val _stateFlow = MutableStateFlow(initialState)
    private var state: S = initialState
        set(value) {
            field = value
            _stateFlow.value = state
        }
    val stateFlow: StateFlow<S> get() = _stateFlow

    suspend fun dispatch(action: A) {
        processMiddlewareChain(0, action) {
            state = reducer(state, it)
        }
    }

    private suspend fun processMiddlewareChain(index: Int, action: A, onComplete: suspend (A) -> Unit) {
        if (index < middlewares.size) {
            middlewares[index].process(action, state) { nextAction ->
                processMiddlewareChain(index + 1, nextAction, onComplete)
            }
        } else {
            onComplete(action) // Call the reducer with the final action
        }
    }
}