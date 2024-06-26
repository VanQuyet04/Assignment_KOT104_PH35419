package com.example.assignment_kot104_ph35419.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.assignment_kot104_ph35419.R
import com.example.assignment_kot104_ph35419.ui.screens.FavouriteScreen
import com.example.assignment_kot104_ph35419.ui.screens.HomeScreen
import com.example.assignment_kot104_ph35419.ui.screens.NotificationScreen
import com.example.assignment_kot104_ph35419.ui.screens.ProfileScreen

enum class ROUTE_BOTTOM_SCREEN {
    Home,
    Favorite,
    Notification,
    Profile
}

@Composable
fun bottom_graph(navController: NavHostController) {

    NavHost( navController, startDestination = ROUTE_BOTTOM_SCREEN.Home.name) {
        composable(ROUTE_BOTTOM_SCREEN.Home.name) { HomeScreen(navController) }
        composable(ROUTE_BOTTOM_SCREEN.Favorite.name) { FavouriteScreen(navController) }
        composable(ROUTE_BOTTOM_SCREEN.Notification.name) { NotificationScreen(navController) }
        composable(ROUTE_BOTTOM_SCREEN.Profile.name) { ProfileScreen(navController) }

    }

}


@Composable
fun BottomNavigationBar(navController: NavController) {

    val items = listOf(
        ROUTE_BOTTOM_SCREEN.Home to R.drawable.ic_home,
        ROUTE_BOTTOM_SCREEN.Favorite to R.drawable.ic_favourite,
        ROUTE_BOTTOM_SCREEN.Notification to R.drawable.ic_notifications,
        ROUTE_BOTTOM_SCREEN.Profile to R.drawable.ic_profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp) // Chiều cao của thanh điều hướng
            .background(
                color = Color.White,
                shape = RoundedCornerShape(35.dp) // Điều chỉnh giá trị này để bo góc
            )
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        NavigationBar(containerColor = Color.White) {
            items.forEach { (route, icon) ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = route.name.replaceFirstChar { it.uppercase() },
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    selected = currentRoute == route.name,
                    onClick = {
                        navController.navigate(route.name) {
                            // Xóa tất cả các trang đích trước để tránh chồng chất trang
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            // Điều hướng đến 1 màn hình duy nhất và không tạo thêm bản sao
                            launchSingleTop = true
                            // Khôi phục trạng thái đã lưu
                            restoreState = true
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.Black,
                        unselectedIconColor = Color.LightGray,
                        indicatorColor = Color.White
                    ),
                    alwaysShowLabel = false,
                )
            }
        }
    }
}
