package com.example.assignment_kot104_ph35419.navigation

import ProductDetailScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.assignment_kot104_ph35419.ui.screens.Home
import com.example.assignment_kot104_ph35419.ui.screens.LoginScreen
import com.example.assignment_kot104_ph35419.ui.screens.SignupScreen
import com.example.assignment_kot104_ph35419.ui.screens.SplashScreen

@Composable
fun main_graph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("signup") { SignupScreen(navController) }

        composable("detail/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")
            productId?.let {
                ProductDetailScreen(navController = navController, productId = it)
            }
        }

        composable("main") { Home() }

    }
}

