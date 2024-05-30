package com.example.assignment_kot104_ph35419.ui.screens

import CustomTopBar
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.assignment_kot104_ph35419.R

data class NotificationItem(
    val id: Int,
    val title: String,
    val description: String,
    val imageRes: Int,
    val isNew: Boolean = false,
    val isHot: Boolean = false
)

val notifications = listOf(
    NotificationItem(
        id = 1,
        title = "Your order #123456789 has been confirmed",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec.",
        imageRes = R.drawable.img_stand,
        isNew = true
    ),
    NotificationItem(
        id = 2,
        title = "Your order #123456789 has been canceled",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec.",
        imageRes = R.drawable.img_lamp
    ),
    NotificationItem(
        id = 3,
        title = "Discover hot sale furnitures this week.",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec.",
        imageRes = R.drawable.img_chair,
        isHot = true
    ),
    NotificationItem(
        id = 4,
        title = "Your order #123456789 has been shipped successfully",
        description = "Please help us to confirm and rate your order to get 10% discount code for next order.",
        imageRes = R.drawable.img_desk
    ),
    NotificationItem(
        id = 5,
        title = "Your order #123456789 has been confirmed",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec.",
        imageRes = R.drawable.img_lamp
    )
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NotificationScreen(navController: NavHostController) {

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
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(notifications) { notification ->
                        NotificationListItem(notification)
                    }
                }
            }
        }
    )
}

@Composable
fun NotificationListItem(notification: NotificationItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = notification.imageRes),
                contentDescription = null,
                modifier = Modifier.size(64.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = notification.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Text(
                    text = notification.description,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                if (notification.isNew) {
                    Text(
                        text = "New",
                        fontSize = 12.sp,
                        color = Color.Green,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
                if (notification.isHot) {
                    Text(
                        text = "HOT!",
                        fontSize = 12.sp,
                        color = Color.Red,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
        Divider(color = Color.LightGray, thickness = 1.dp)
    }
}
