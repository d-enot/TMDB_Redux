package com.ksyen.movies_redux.di

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object CoroutineModule {
    @Provides
    @Singleton
    fun provideCoroutineScope(): CoroutineContext {
        Log.d("HiltShit", "Providing CoroutineContext")
        return SupervisorJob() + Dispatchers.IO
    }
}