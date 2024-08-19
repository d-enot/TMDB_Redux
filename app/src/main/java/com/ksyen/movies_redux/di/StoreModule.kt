package com.ksyen.movies_redux.di

import com.ksyen.movies_redux.redux.OnAirShowsMiddleware
import com.ksyen.movies_redux.redux.OnAirShowsState
import com.ksyen.movies_redux.redux.PopularShowsMiddleware
import com.ksyen.movies_redux.redux.PopularShowsState
import com.ksyen.movies_redux.redux.ShowsActions
import com.ksyen.movies_redux.redux.Store
import com.ksyen.movies_redux.redux.onAirShowsReducer
import com.ksyen.movies_redux.redux.popularShowsReducer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object StoreModule {
    @Provides
    fun provideOnAirShowsStore(
        onAirShowsMiddleware: OnAirShowsMiddleware,
    ): Store<OnAirShowsState, ShowsActions> {
        return Store(
            initialState = OnAirShowsState(),
            reducer = ::onAirShowsReducer,
            middlewares = listOf(onAirShowsMiddleware)
        )
    }

    @Provides
    fun providePopularShowsStore(
        popularShowsMiddleware: PopularShowsMiddleware,
    ): Store<PopularShowsState, ShowsActions> {
        return Store(
            initialState = PopularShowsState(),
            reducer = ::popularShowsReducer,
            middlewares = listOf(popularShowsMiddleware)
        )
    }
}