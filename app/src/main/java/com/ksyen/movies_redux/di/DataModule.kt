package com.ksyen.movies_redux.di

import com.ksyen.movies_redux.data.ShowsRepositoryImpl
import com.ksyen.movies_redux.data.network.ShowsApi
import com.ksyen.movies_redux.data.network.ShowsNetworkDataSource
import com.ksyen.movies_redux.domain.ShowsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideNetworkDataSource(
        showsApi: ShowsApi,
        coroutineContext: CoroutineContext
    ): ShowsNetworkDataSource = ShowsNetworkDataSource(showsApi, coroutineContext)

    @Provides
    @Singleton
    fun provideShowsRepository(
        dataSource: ShowsNetworkDataSource
    ): ShowsRepository = ShowsRepositoryImpl(dataSource)
}