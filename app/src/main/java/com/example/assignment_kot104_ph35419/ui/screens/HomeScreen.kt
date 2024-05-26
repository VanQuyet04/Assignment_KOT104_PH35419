package com.example.assignment_kot104_ph35419.ui.screens

import CustomTopBar
import android.annotation.SuppressLint

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape


import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.assignment_kot104_ph35419.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(nav: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
        ) {
            CustomTopBar(
                title = "Make home",
                subtitle = "Beautiful",
                leftIconId = R.drawable.timkiem,
                rightIconId = R.drawable.giohang,
                onLeftClick = { },
                onRightClick = {
                    nav.navigate("cart")
                }

            ) {}
            Spacer(modifier = Modifier.height(16.dp))
            CategoryRow()
            Spacer(modifier = Modifier.height(16.dp))
            ProductGrid(nav)
        }
    }

}


@Composable
fun CategoryRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CategoryItem(R.drawable.ic_popular, "Popular")
        CategoryItem(R.drawable.ic_table, "Table")
        CategoryItem(R.drawable.ic_armchair, "Armchair")
        CategoryItem(R.drawable.ic_bed, "Bed")
        CategoryItem(R.drawable.ic_lamp, "Lamp")
    }
}

@Composable
fun CategoryItem(iconRes: Int, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(4.dp)
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.Gray.copy(alpha = 0.1f))
                .padding(8.dp)
        )
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Gray
        )
    }
}

@Composable
fun ProductGrid(
    navController: NavController

) {
    val products = listOf(
        Product(1,R.drawable.img_lamp, "Black Simple Lamp", "$ 12.00", 50, "Ngon bá cháy"),
        Product(2,R.drawable.img_stand, "Minimal Stand", "$ 25.00", 53, "Ngon bá khét"),
        Product(3,R.drawable.img_chair, "Coffee Chair", "$ 20.00", 55, "Ngon bá bá"),
        Product(4,R.drawable.img_desk, "Simple Desk", "$ 50.00", 52, "Ngon bá khí"),
        Product(5,R.drawable.img_stand, "Normal Desk", "$ 40.00", 59, "Ngon bá đạo"),
        Product(6,R.drawable.img_desk, "Hard Desk", "$ 60.00", 56, "Ngon bá bú"),
        Product(7,R.drawable.img_lamp, "Soft Desk", "$ 70.00", 54, "Ngon bá chó"),
        Product(8,R.drawable.img_chair, "Office Desk", "$ 80.00", 55, "Ngon bá chém"),
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 0.dp, 0.dp, 60.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(products.size) { index ->
            ProductItem(products[index], onClick = {
                navController.navigate("detail/${products[index].id}")
            })
        }
    }
}

@Composable
fun ProductItem(product: Product, onClick: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                onClick()
            },

        ) {
        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = product.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = product.name,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = product.price,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun BottomNavigationBar(nav: NavController) {
    var selectedItem by remember { mutableStateOf("home") }

    NavigationBar(
        containerColor = Color.White,
    ) {

        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "Home",
                    modifier = Modifier.size(24.dp),
                )
            },
            selected = selectedItem == "home",
            onClick = {
                selectedItem = "home"
                nav.navigate("home")
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Gray,
                indicatorColor = Color.White
            ),
            alwaysShowLabel = false,
        )

        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_favourite),
                    contentDescription = "Favourite",
                    modifier = Modifier.size(24.dp)
                )
            },
            selected = selectedItem == "favourite",
            onClick = {
                selectedItem = "favourite"
                nav.navigate("favourite")
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Gray,
                indicatorColor = Color.White
            ),
            alwaysShowLabel = false,
        )

        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_notifications),
                    contentDescription = "Notifications",
                    modifier = Modifier.size(24.dp)
                )
            },
            selected = selectedItem == "notification",
            onClick = {
                selectedItem = "notification"
                nav.navigate("notification")
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Gray,
                indicatorColor = Color.White
            ),
            alwaysShowLabel = false,
        )

        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "Profile",
                    modifier = Modifier.size(24.dp)
                )
            },
            selected = selectedItem == "profile",
            onClick = {
                selectedItem = "profile"
                nav.navigate("profile")
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

data class Product(
    val id:Int,
    val imageRes: Int,
    val name: String,
    val price: String,
    val quantity: Int,
    val description: String
)
