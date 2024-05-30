package com.example.assignment_kot104_ph35419.ui.screens

import CustomTopBar
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.assignment_kot104_ph35419.R
import com.example.assignment_kot104_ph35419.navigation.BottomNavigationBar
import com.example.assignment_kot104_ph35419.navigation.ROUTE_MAIN_SCREEN
import com.example.assignment_kot104_ph35419.navigation.bottom_graph
import getTopBarState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(navController: NavHostController) {
    val bottomNavController = rememberNavController()

    val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val topBarState = getTopBarState(currentRoute)

    Scaffold(
        topBar = {
            CustomTopBar(
                title = topBarState.title,
                subtitle = topBarState.subtitle,
                leftIconId = topBarState.leftIconId,
                rightIconId = topBarState.rightIconId,
                onLeftClick = { },
                onRightClick = {
                    navController.navigate(ROUTE_MAIN_SCREEN.cart.name)
                }
            )
        },
        bottomBar = { BottomNavigationBar(navController = bottomNavController) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            bottom_graph(navController = bottomNavController)
        }
    }
}

