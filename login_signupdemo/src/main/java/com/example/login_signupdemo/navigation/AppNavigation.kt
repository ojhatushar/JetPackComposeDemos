package com.example.login_signupdemo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.login_signupdemo.screens.homescreen.HomeScreen
import com.example.login_signupdemo.screens.signinsignup.SignUpScreen
import com.example.login_signupdemo.screens.splash.SplashScreen

sealed class EcommerceScreen(val route: String) {
    object Splash : EcommerceScreen("Splash")
    object Register : EcommerceScreen("Register")
    object Home : EcommerceScreen("Home")
}

@Composable
fun EcommerceApp() {
    //Create NavController
    val navController = rememberNavController()
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = backStackEntry?.destination?.route ?: EcommerceScreen.Splash.route


    NavHost(navController = navController, startDestination = EcommerceScreen.Splash.route) {
        composable(route = EcommerceScreen.Splash.route) {
            SplashScreen(
                onSignInButtonClicked = { navController.navigate(EcommerceScreen.Home.route + "/Test@test.com") },
                onRegisterTextClicked = { navController.navigate(EcommerceScreen.Register.route) }
            )
        }

        composable(route = EcommerceScreen.Register.route) {
            SignUpScreen(onBackButtonClicked = {
                navController.navigateUp()

                /* navController.popBackStack(
                     EcommerceScreen.Splash.name,
                     inclusive = false
                 )*/

            },
                onLoginTextClicked = {
                    navController.navigateUp()

                    /* navController.navigate(EcommerceScreen.Splash.name) {

                          navController.popBackStack(
                              EcommerceScreen.Splash.name,
                              inclusive = true
                          )

                         popUpTo(navController.graph.id) {
                             inclusive = true
                         }
                     }*/
                }

            )
        }
        /*composable(route = EcommerceScreen.Home.route + "/{email}") {
            val email = it.arguments?.getString("email")
            if (email != null) {
                HomeScreen(email)
            }
        }*/

        composable(
            route = EcommerceScreen.Home.route + "/{email}",
            arguments = listOf(navArgument(name = "email") {
                type = NavType.StringType
            })
        ) {
            val email = it.arguments?.getString("email")
            if (email != null) {
                HomeScreen(email)
            }
        }
    }

}
