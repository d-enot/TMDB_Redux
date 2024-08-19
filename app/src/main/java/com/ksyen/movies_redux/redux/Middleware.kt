package com.ksyen.movies_redux.redux

interface Middleware<S, A> {
    suspend fun process(action: A, currentState: S, next: suspend (A) -> Unit)
}