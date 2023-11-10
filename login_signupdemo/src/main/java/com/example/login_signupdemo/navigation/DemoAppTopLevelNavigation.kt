package com.example.login_signupdemo.navigation

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.navOptions
import com.example.login_signupdemo.R
import com.example.login_signupdemo.screens.calender.navigation.calenderRoute
import com.example.login_signupdemo.screens.calender.navigation.navigateToCalender
import com.example.login_signupdemo.screens.homescreen.navigation.homeRoute
import com.example.login_signupdemo.screens.homescreen.navigation.navigateToHome

class DemoAppTopLevelNavigation(private val navController: NavHostController) {

    fun navigateTo(topLevelDestination: String) {
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
            homeRoute -> navController.navigateToHome("fsdfsds", topLevelNavOptions)
            calenderRoute -> navController.navigateToCalender(topLevelNavOptions)
        }
    }
}

data class TopLevelDestination(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int
)

val TOP_LEVEL_DESTINATIONS = listOf(
    TopLevelDestination(
        route = homeRoute,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        iconTextId = R.string.home
    ),
    TopLevelDestination(
        route = calenderRoute,
        selectedIcon = Icons.Filled.DateRange,
        unselectedIcon = Icons.Outlined.DateRange,
        iconTextId = R.string.calendar
    ),
)
