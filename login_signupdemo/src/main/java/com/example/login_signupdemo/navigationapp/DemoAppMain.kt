package com.example.login_signupdemo.navigationapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.login_signupdemo.components.NavigationBarMain
import com.example.login_signupdemo.components.NavigationItem
import com.example.login_signupdemo.navigation.DemoAppTopLevelNavigation
import com.example.login_signupdemo.navigation.DemoNavHost
import com.example.login_signupdemo.navigation.TOP_LEVEL_DESTINATIONS
import com.example.login_signupdemo.navigation.TopLevelDestination


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DemoAppMain() {
    //Create NavController
    val navController = rememberNavController()
    val doseTopLevelNavigation = remember(navController) {
        DemoAppTopLevelNavigation(navController)
    }
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination

    val bottomBarVisibility = rememberSaveable { (mutableStateOf(true)) }

    // Get the name of the current screen
    // val currentScreen = backStackEntry?.destination?.route ?: EcommerceScreen.Splash.route


    Scaffold(
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        bottomBar = {
            AnimatedVisibility(
                visible = bottomBarVisibility.value,
                enter = slideInVertically(initialOffsetY = { it }),
                exit = slideOutVertically(targetOffsetY = { it }),
            ) {
                BottomBar(
                    onNavigateToTopLevelDestination = doseTopLevelNavigation::navigateTo,
                    currentDestination = currentDestination
                )
            }

        }
    )
    { padding ->
        Row(
            Modifier
                .fillMaxSize()
                .padding(padding)
                .consumeWindowInsets(padding)
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal,
                    ),
                ),
        ) {
            DemoNavHost(navController = navController,  bottomBarVisibility = bottomBarVisibility)
        }
    }
}

@Composable
fun BottomBar(
    onNavigateToTopLevelDestination: (String) -> Unit,
    currentDestination: NavDestination?
) {
    NavigationBarMain(modifier = Modifier) {

        TOP_LEVEL_DESTINATIONS.forEach { destination ->
           /* val selected =
                currentDestination?.hierarchy?.any { it.route == destination.route } == true*/

            val selected =
                currentDestination?.hierarchy?.any {
                    it.route?.contains(destination.route, true) ?: false
                } ?: false

            NavigationItem(
                selected = selected,
                onClick = { onNavigateToTopLevelDestination(destination.route) },
                icon = {
                    Icon(
                        if (selected) {
                            destination.selectedIcon
                        } else {
                            destination.unselectedIcon
                        },
                        contentDescription = null
                    )
                },
                label = { Text(stringResource(destination.iconTextId)) }
            )
        }

    }
}

