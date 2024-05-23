package com.example.assignment_kot104_ph35419.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview

import androidx.navigation.compose.rememberNavController

import com.example.assignment_kot104_ph35419.navigation.main_navhost


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            main_navhost(navController = navController)
        }
    }
}

@Composable
fun SplashScreen() {

}

@Preview(showBackground = true)
@Composable
fun BoardingScreenPreview() {

}