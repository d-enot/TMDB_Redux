package com.ksyen.movies_redux.data.network

import com.ksyen.movies_redux.data.network.model.ShowsResult
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ShowsApi {
    @Headers(
        "Accept: application/json"
    )
    @GET("tv/on_the_air")
    suspend fun getOnAirShows(
        @Header("Authorization") token: String,
        @Query("language") language: String,
        @Query("page") page: Int = 1,
        @Query("watch_region") region: String = "GB"
    ): ShowsResult

    @Headers(
        "Accept: application/json"
    )
    @GET("tv/top_rated")
    suspend fun getPopularShows(
        @Header("Authorization") token: String,
        @Query("language") language: String,
        @Query("page") page: Int = 1
    ): ShowsResult
}