package com.example.login_signupdemo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.login_signupdemo.navigationapp.DemoAppState
import com.example.login_signupdemo.screens.calender.navigation.calenderScreen
import com.example.login_signupdemo.screens.signinsignup.navigation.navigateToRegister
import com.example.login_signupdemo.screens.signinsignup.navigation.signUpScreen
import com.example.login_signupdemo.screens.homescreen.navigation.homeScreen
import com.example.login_signupdemo.screens.homescreen.navigation.navigateToHome
import com.example.login_signupdemo.screens.splash.navigation.splashRoute
import com.example.login_signupdemo.screens.splash.navigation.splashScreen

@Composable
fun DemoNavHost(
    bottomBarVisibility: MutableState<Boolean>,
    appState: DemoAppState,
    startDestination: String = splashRoute
) {
    val navController = appState.navController
    NavHost(navController = navController, startDestination = startDestination) {
        splashScreen(
            bottomBarVisibility,
            onSignInButtonClicked = { navController.navigateToRegister(false) },
            onRegisterTextClicked = { navController.navigateToRegister(true) }
        )

        signUpScreen(
            onBackButtonClicked = { navController.navigateUp() },
            onLoginTextClicked = navController::navigateUp,
            onValidate = {
                navController.navigateToHome(it)
            }
        )
        homeScreen(bottomBarVisibility = bottomBarVisibility)
        calenderScreen()
    }
}

