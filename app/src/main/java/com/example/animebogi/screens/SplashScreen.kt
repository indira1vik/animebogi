package com.example.animebogi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.animebogi.R
import com.example.animebogi.ui.theme.CornGreen
import com.example.animebogi.ui.theme.PakGreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = CornGreen, RectangleShape),
        Alignment.Center){
        Image(
            painter = painterResource(R.drawable.anime),
            contentDescription = null
        )

        Text(
            text = "AnimeBogi",
            style = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(40.dp,300.dp,40.dp,0.dp)
        )
        Text(
            text = "The Anime List",
            style = TextStyle(fontSize = 20.sp),
            modifier = Modifier.padding(20.dp,400.dp,20.dp,0.dp)
        )
    }
    LaunchedEffect(key1 = true) {
        delay(2000L)
        navController.popBackStack()
        navController.navigate("main_screen")
    }
}