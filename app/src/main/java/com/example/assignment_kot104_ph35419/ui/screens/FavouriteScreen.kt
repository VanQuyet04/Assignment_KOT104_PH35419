package com.example.assignment_kot104_ph35419.ui.screens

import CustomTopBar
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.assignment_kot104_ph35419.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FavouriteScreen(navController: NavHostController) {
    val productList = remember {
        mutableStateListOf(
            Product(1, R.drawable.img_lamp, "Black Simple Lamp", "$ 12.00", 50, "Ngon bá cháy"),
            Product(2, R.drawable.img_stand, "Minimal Stand", "$ 25.00", 53, "Ngon bá khét"),
            Product(3, R.drawable.img_chair, "Coffee Chair", "$ 20.00", 55, "Ngon bá bá"),
            Product(4, R.drawable.img_desk, "Simple Desk", "$ 50.00", 52, "Ngon bá khí"),
            )
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                CustomTopBar(
                    title = "My favourite",
                    subtitle = null,
                    leftIconId = R.drawable.back,
                    rightIconId = R.drawable.giohang,
                    onLeftClick = { navController.popBackStack() },
                    onRightClick = { navController.navigate("cart") }
                ) {}
                Spacer(modifier = Modifier.height(16.dp))
                ProductList(productList)
                AddAllToCartButton(
                    onClick = { /* Xử lý thêm tất cả vào giỏ hàng */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                )
            }
        }
    )
}

@Composable
fun ProductList(products: List<Product>) {
    LazyColumn (
        modifier = Modifier.padding(bottom = 10.dp)
    ){
        items(products.size) { index ->
            val product = products[index]
            ProductItem(
                product = product,
                onAddToCart = { /* TODO: Handle add to cart */ },
                onRemove = { /* TODO: Handle remove item */ }
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun ProductItem(product: Product, onAddToCart: () -> Unit, onRemove: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White) // Change this to desired color

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = product.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = product.price, fontSize = 14.sp, color = Color.Gray)
            }
            IconButton(onClick = onRemove) {
                Icon(imageVector = Icons.Filled.Delete, contentDescription = "Remove")
            }
            IconButton(onClick = onAddToCart) {
                Icon(imageVector = Icons.Filled.AddShoppingCart, contentDescription = "Add to Cart")
            }
        }
    }
}

@Composable
fun AddAllToCartButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
    ) {
        Text(text = "Add all to my cart", color = Color.White)
    }
}
