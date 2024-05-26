package com.example.assignment_kot104_ph35419.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.assignment_kot104_ph35419.R
import com.example.assignment_kot104_ph35419.ui.screens.FavouriteScreen
import com.example.assignment_kot104_ph35419.ui.screens.HomeScreen
import com.example.assignment_kot104_ph35419.ui.screens.NotificationScreen
import com.example.assignment_kot104_ph35419.ui.screens.ProfileScreen

@Composable
fun bottom_graph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("notification") { NotificationScreen(navController) }
        composable("favourite") { FavouriteScreen(navController) }
        composable("profile") { ProfileScreen(navController) }

    }
}


@Composable
fun BottomNavigationBar(nav: NavController) {
    var selectedItem by remember { mutableStateOf("home") }

    val items = listOf(
        "home" to R.drawable.ic_home,
        "favourite" to R.drawable.ic_favourite,
        "notification" to R.drawable.ic_notifications,
        "profile" to R.drawable.ic_profile
    )

    NavigationBar(containerColor = Color.White) {
        items.forEach { (name, icon) ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = name.replaceFirstChar { it.uppercase() },
                        modifier = Modifier.size(24.dp)
                    )
                },
                selected = selectedItem == name,
                onClick = {
                    selectedItem = name
                    nav.navigate(name) {
                        //Xóa tất cả các trang đich trước để tránh chồng chất trang
                        popUpTo(nav.graph.startDestinationId) {
                            saveState = true
                        }

                        // Điều hướng đến 1 màn hình duy nhất và k tạo thêm bản sao
                        launchSingleTop = true

                        // Khôi phục trạng thái đã lưu
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    unselectedIconColor = Color.Gray,
                    indicatorColor = Color.White
                ),
                alwaysShowLabel = false,
            )
        }
    }
}
