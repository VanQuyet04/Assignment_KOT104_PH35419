package com.example.assignment_kot104_ph35419.ui.screens

import CustomTopBar
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.assignment_kot104_ph35419.R
import kotlin.system.exitProcess

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController: NavHostController) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        content = {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {

                    Spacer(modifier = Modifier.height(16.dp))
                    ProfileHeader()
                    Spacer(modifier = Modifier.height(40.dp))
                    UtilityList()
                }
            }
        }
    )
}

@Composable
fun ProfileHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.quyet),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape) // Clip the image to be a circle
                .background(Color.LightGray.copy(alpha = 0.5f), CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = "Quyet Van", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = "quyetvan204@gmail.com", fontSize = 16.sp, color = Color.Gray)
        }
    }
}

@Composable
fun UtilityList() {
    Column {
        UtilityItem(
            title = "My orders",
            subtitle = "Already have 10 orders",
            onClick = { /* TODO: Handle click */ }
        )
        UtilityItem(
            title = "Shipping Addresses",
            subtitle = "03 Addresses",
            onClick = { /* TODO: Handle click */ }
        )
        UtilityItem(
            title = "Payment Method",
            subtitle = "You have 2 cards",
            onClick = { /* TODO: Handle click */ }
        )
        UtilityItem(
            title = "My reviews",
            subtitle = "Reviews for 5 items",
            onClick = { /* TODO: Handle click */ }
        )
        UtilityItem(
            title = "Setting",
            subtitle = "Notification, Password, FAQ, Contact",
            onClick = { /* TODO: Handle click */ }
        )
    }
}

@Composable
fun UtilityItem(title: String, subtitle: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp) // Adds spacing between items
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp) ,
        colors = CardDefaults.cardColors(containerColor = Color.White) // Change this to desired color

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp).padding(10.dp) // Adds padding inside the card
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = subtitle, fontSize = 14.sp, color = Color.Gray)
            }
            Icon(
                imageVector = Icons.Filled.ChevronRight,
                contentDescription = "Arrow icon",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
