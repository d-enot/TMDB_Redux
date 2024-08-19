package com.ksyen.movies_redux.videosbottombar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ksyen.movies_redux.onairshows.OnAirShowsView
import com.ksyen.movies_redux.popularshows.PopularShowsView

@Composable
fun VideosBottomBarView(modifier: Modifier) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                videosBottomBarTabs.forEach { item ->
                    NavigationBarItem(
                        selected = currentDestination?.route == item.rout,
                        label = { Text(stringResource(item.label)) },
                        icon = {
                            Icon(
                                painter = painterResource(item.icon),
                                contentDescription = stringResource(item.label)
                            )
                        },
                        onClick = {
                            navController.navigate(item.rout) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = BottomNavigationItems.OnTheAir.rout,
            modifier = modifier.padding(paddingValues = paddingValues)
        ) {
            composable(route = BottomNavigationItems.OnTheAir.rout) { OnAirShowsView(modifier) }
            composable(route = BottomNavigationItems.Popular.rout) { PopularShowsView(modifier) }
        }
    }
}