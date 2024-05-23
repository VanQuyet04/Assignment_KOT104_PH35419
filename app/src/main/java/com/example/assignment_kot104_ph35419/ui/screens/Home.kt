package com.example.assignment_kot104_ph35419.ui.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem


import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment_kot104_ph35419.R
import com.example.assignment_kot104_ph35419.ui.theme.Assignment_KOT104_PH35419Theme

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment_KOT104_PH35419Theme {
                HomeScreen()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
        ) {
            TopBar()
            Spacer(modifier = Modifier.height(16.dp))
            CategoryRow()
            Spacer(modifier = Modifier.height(16.dp))
            ProductGrid()
        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /* TODO: Add search action */ }) {
            Icon(
                painter = painterResource(id = R.drawable.timkiem),
                contentDescription = "Search",
                modifier = Modifier.size(32.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Make home BEAUTIFUL",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(4f)
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { /* TODO: Add cart action */ }) {
            Icon(
                painter = painterResource(id = R.drawable.giohang),
                contentDescription = "Cart",
                modifier = Modifier.size(32.dp)
            )
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
fun ProductGrid() {
    val products = listOf(
        Product(R.drawable.img_lamp, "Black Simple Lamp", "$ 12.00"),
        Product(R.drawable.img_stand, "Minimal Stand", "$ 25.00"),
        Product(R.drawable.img_chair, "Coffee Chair", "$ 20.00"),
        Product(R.drawable.img_desk, "Simple Desk", "$ 50.00")
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(products.size) { index ->
            ProductItem(products[index])
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
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
fun BottomNavigationBar() {
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "Home",
                    modifier = Modifier.size(36.dp)
                )
            },
            selected = true,
            onClick = { /* TODO: Add action */ },
            alwaysShowLabel = false
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_bookmark),
                    contentDescription = "Bookmark",
                    modifier = Modifier.size(36.dp)
                )
            },
            selected = false,
            onClick = { /* TODO: Add action */ },
            alwaysShowLabel = false
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_notifications),
                    contentDescription = "Notifications",
                    modifier = Modifier.size(36.dp)
                )
            },
            selected = false,
            onClick = { /* TODO: Add action */ },
            alwaysShowLabel = false
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "Profile",
                    modifier = Modifier.size(36.dp)
                )
            },
            selected = false,
            onClick = { /* TODO: Add action */ },
            alwaysShowLabel = false
        )
    }
}

data class Product(val imageRes: Int, val name: String, val price: String)

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Assignment_KOT104_PH35419Theme {
        HomeScreen()
    }
}