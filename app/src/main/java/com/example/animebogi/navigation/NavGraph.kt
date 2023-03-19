package com.example.animebogi.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animebogi.screens.HomeScreen
import com.example.animebogi.screens.SplashScreen
import com.example.animebogi.MainView
import com.example.animebogi.data.Entry
import com.example.animebogi.screens.WatchList

@Composable
fun NavGraph(viewModel: MainView){
    val saveList = remember { mutableStateListOf<Entry>() }
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable("main_screen") {
            HomeScreen(viewModel = viewModel,navController = navController,saveList)
        }
        composable("watch_screen"){
            WatchList(navController = navController,saveList)
        }
    }
}