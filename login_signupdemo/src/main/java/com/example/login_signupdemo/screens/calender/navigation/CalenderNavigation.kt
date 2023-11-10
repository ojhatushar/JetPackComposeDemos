package com.example.login_signupdemo.screens.calender.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.login_signupdemo.screens.calender.CalendarScreen
import com.example.login_signupdemo.screens.splash.SplashScreen

const val calenderRoute = "calender_route"

fun NavController.navigateToCalender(navOptions: NavOptions? = null) {
    this.navigate(calenderRoute, navOptions)
}

fun NavGraphBuilder.calenderScreen() {
    // TODO: Handle back stack for each top-level destination. At the moment each top-level
    // destination may have own search screen's back stack.
    composable(route = calenderRoute) {
        CalendarScreen()
    }
}
