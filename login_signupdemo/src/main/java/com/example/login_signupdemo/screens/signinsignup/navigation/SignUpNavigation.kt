package com.example.login_signupdemo.screens.signinsignup.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.login_signupdemo.screens.signinsignup.SignUpScreen

const val signUpRoute = "sign_up_route"
const val isRegisterArg = "isRegister"


fun NavController.navigateToRegister(isRegister: Boolean, navOptions: NavOptions? = null) {
    this.navigate("$signUpRoute/$isRegister", navOptions)
}

fun NavGraphBuilder.signUpScreen(
    onBackButtonClicked: () -> Unit,
    onLoginTextClicked: () -> Unit,
    onValidate: (String) -> Unit
) {
    // TODO: Handle back stack for each top-level destination. At the moment each top-level
    // destination may have own search screen's back stack.
    composable(
        route = "$signUpRoute/{$isRegisterArg}",
        arguments = listOf(navArgument(name = isRegisterArg) {
            type = NavType.BoolType

        })
    ) {
        SignUpScreen(
            isRegister = it.arguments?.getBoolean(isRegisterArg)!!,
            onBackButtonClicked,
            onLoginTextClicked,
            onValidate
        )
    }
}
