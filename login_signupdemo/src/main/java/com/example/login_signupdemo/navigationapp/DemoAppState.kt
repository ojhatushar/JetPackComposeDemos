package com.example.login_signupdemo.navigationapp

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.login_signupdemo.navigation.TopLevelDestination
import com.example.login_signupdemo.screens.calender.navigation.calenderRoute
import com.example.login_signupdemo.screens.calender.navigation.navigateToCalender
import com.example.login_signupdemo.screens.homescreen.navigation.homeRoute
import com.example.login_signupdemo.screens.homescreen.navigation.homeRouteBottomNavi
import com.example.login_signupdemo.screens.homescreen.navigation.navigateToHome


@Composable
fun rememberNiaAppState(
    navController: NavHostController = rememberNavController()
): DemoAppState {
    return remember(navController) {
        DemoAppState(navController)
    }
}

class DemoAppState(val navController: NavHostController) {

    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            homeRouteBottomNavi -> TopLevelDestination.HOME
            calenderRoute -> TopLevelDestination.CALENDER
            else -> null
        }

    /**
     * Map of top level destinations to be used in the TopBar, BottomBar and NavRail. The key is the
     * route.
     */
    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()


    fun navigateTo(topLevelDestination: TopLevelDestination) {
        /*  navController.navigate(destination.route) {
              // Pop up to the start destination of the graph to
              // avoid building up a large stack of destinations
              // on the back stack as users select items
              popUpTo(navController.graph.findStartDestination().id) {
                  saveState = true
              }
              // Avoid multiple copies of the same destination when
              // reselecting the same item
              launchSingleTop = true
              // Restore state when reselecting a previously selected item
              restoreState = true
          }*/


        val topLevelNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }

        when (topLevelDestination) {
            TopLevelDestination.HOME -> navController.navigateToHome("fsdfsds", topLevelNavOptions)
            TopLevelDestination.CALENDER -> navController.navigateToCalender(topLevelNavOptions)
        }
    }
}