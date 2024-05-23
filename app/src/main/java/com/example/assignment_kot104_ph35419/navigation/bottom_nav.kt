package com.example.assignment_kot104_ph35419.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.assignment_kot104_ph35419.ui.screens.CartScreen
import com.example.assignment_kot104_ph35419.ui.screens.FavouriteScreen
import com.example.assignment_kot104_ph35419.ui.screens.HomeScreen
import com.example.assignment_kot104_ph35419.ui.screens.NotificationScreen
import com.example.assignment_kot104_ph35419.ui.screens.ProfileScreen

@Composable
fun bottom_navhost(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "home") {
        composable("notification") { NotificationScreen() }
        composable("favourite") { FavouriteScreen() }
        composable("profile") { ProfileScreen() }
        composable("cart") { CartScreen() }
        composable("home") { HomeScreen(navController) }
    }
}