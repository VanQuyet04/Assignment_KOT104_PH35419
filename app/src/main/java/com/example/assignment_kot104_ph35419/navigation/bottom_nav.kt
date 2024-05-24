package com.example.assignment_kot104_ph35419.navigation

import CartScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.assignment_kot104_ph35419.ui.screens.FavouriteScreen
import com.example.assignment_kot104_ph35419.ui.screens.HomeScreen
import com.example.assignment_kot104_ph35419.ui.screens.NotificationScreen
import com.example.assignment_kot104_ph35419.ui.screens.ProfileScreen

@Composable
fun bottom_navhost(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("notification") { NotificationScreen(navController) }
        composable("favourite") { FavouriteScreen(navController) }
        composable("profile") { ProfileScreen(navController) }

        composable("cart") { CartScreen(navController) }

        // màn home chung navCtrl với các màn bottom nav

    }
}