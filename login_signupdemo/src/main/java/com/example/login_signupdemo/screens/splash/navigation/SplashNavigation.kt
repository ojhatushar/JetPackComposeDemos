package com.example.login_signupdemo.screens.splash.navigation

import androidx.compose.runtime.MutableState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.login_signupdemo.screens.splash.SplashScreen

const val splashRoute = "splash_route"

/*fun NavController.navigateToRegister(navOptions: NavOptions? = null) {
    this.navigate(splashRoute, navOptions)
}*/

fun NavGraphBuilder.splashScreen(
    bottomBarVisibility: MutableState<Boolean>,
    onSignInButtonClicked: () -> Unit,
    onRegisterTextClicked: () -> Unit
) {
    // TODO: Handle back stack for each top-level destination. At the moment each top-level
    // destination may have own search screen's back stack.
    composable(route = splashRoute) {
        bottomBarVisibility.value = false
        SplashScreen(
            onSignInButtonClicked = onSignInButtonClicked,
            onRegisterTextClicked = onRegisterTextClicked
        )
    }
}
