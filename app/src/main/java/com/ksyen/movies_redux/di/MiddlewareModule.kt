package com.ksyen.movies_redux.di

import com.ksyen.movies_redux.domain.ShowsRepository
import com.ksyen.movies_redux.redux.OnAirShowsMiddleware
import com.ksyen.movies_redux.redux.PopularShowsMiddleware
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object MiddlewareModule {
    @Provides
    fun provideOnAirShowsMiddleware(
        repository: ShowsRepository
    ): OnAirShowsMiddleware = OnAirShowsMiddleware(repository)

    @Provides
    fun providePopularMiddleware(
        repository: ShowsRepository
    ): PopularShowsMiddleware = PopularShowsMiddleware(repository)
}