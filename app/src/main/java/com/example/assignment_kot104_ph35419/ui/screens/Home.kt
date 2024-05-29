package com.example.assignment_kot104_ph35419.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.assignment_kot104_ph35419.navigation.BottomNavigationBar
import com.example.assignment_kot104_ph35419.navigation.bottom_graph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home() {

    val bottomnavController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(bottomnavController) }
    ) {
        bottom_graph(bottomnavController)
    }

}
