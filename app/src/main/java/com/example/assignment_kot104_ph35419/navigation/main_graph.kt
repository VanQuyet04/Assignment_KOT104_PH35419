package com.example.assignment_kot104_ph35419.navigation

import CartScreen
import ProductDetailScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.assignment_kot104_ph35419.ui.screens.Home
import com.example.assignment_kot104_ph35419.ui.screens.LoginScreen
import com.example.assignment_kot104_ph35419.ui.screens.SignupScreen
import com.example.assignment_kot104_ph35419.ui.screens.SplashScreen

enum class ROUTE_MAIN_SCREEN {
    splash,
    login,
    signup,
    cart,
    main,

}


@Composable
fun main_graph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = ROUTE_MAIN_SCREEN.splash.name) {

        composable(ROUTE_MAIN_SCREEN.splash.name) { SplashScreen(navController) }
        composable(ROUTE_MAIN_SCREEN.login.name) { LoginScreen(navController) }
        composable(ROUTE_MAIN_SCREEN.signup.name) { SignupScreen(navController) }
        composable(ROUTE_MAIN_SCREEN.cart.name) { CartScreen(navController) }

        composable(ROUTE_MAIN_SCREEN.main.name) { Home() }



    }
}

