package com.example.login_signupdemo.navigationapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope


@Composable
fun rememberNiaAppState(
    navController: NavHostController = rememberNavController(),
): DemoAppState {
    return remember(
        navController
    ) {
        DemoAppState(
            navController
        )
    }
}

class DemoAppState(val navController: NavHostController) {

}