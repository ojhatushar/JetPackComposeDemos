package com.example.login_signupdemo.screens.homescreen.navigation

import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.login_signupdemo.screens.homescreen.HomeScreen

const val homeRoute = "home_route"
const val emailIdArg = "emailId"
const val homeRouteBottomNavi="home_route/{$emailIdArg}"

fun NavController.navigateToHome(email:String,navOptions: NavOptions? = null) {
    this.navigate("$homeRoute/$email", navOptions)
}

fun NavGraphBuilder.homeScreen(bottomBarVisibility: MutableState<Boolean>,) {
    // TODO: Handle back stack for each top-level destination. At the moment each top-level
    // destination may have own search screen's back stack.
    composable(route = "$homeRoute/{$emailIdArg}") {
        bottomBarVisibility.value = true
        HomeScreen(email = it.arguments?.getString(emailIdArg)!!)
    }
}
