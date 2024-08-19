package com.ksyen.movies_redux.videosbottombar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.ksyen.movies_redux.R

internal sealed class BottomNavigationItems(
    val rout: String,
    @StringRes val label: Int,
    @DrawableRes val icon: Int
) {
    object OnTheAir : BottomNavigationItems(
        "on_air_shows",
        R.string.bottom_tab_on_air,
        R.drawable.baseline_personal_video_24
    )

    object Popular : BottomNavigationItems(
        "popular",
        R.string.bottom_tab_popular,
        R.drawable.outline_auto_mode_24
    )
}

internal val videosBottomBarTabs = listOf(
    BottomNavigationItems.OnTheAir,
    BottomNavigationItems.Popular
)