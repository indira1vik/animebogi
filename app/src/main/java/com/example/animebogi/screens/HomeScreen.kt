package com.example.animebogi.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.animebogi.MainView
import com.example.animebogi.data.Entry
import com.example.animebogi.ui.theme.CornGreen
import com.example.animebogi.ui.theme.MossGreen
import com.example.animebogi.ui.theme.PakGreen

@Composable
fun HomeScreen(viewModel: MainView, navController: NavController,saveList: MutableList<Entry>){
    val appName = "AnimeBogi"
    Scaffold(
        topBar = { TopBar(appName) },
        bottomBar = { BottomBar(navController) }
    ){
        Contents(viewModel = viewModel, navController = navController, saveList)
    }

}

@Composable
fun BottomBar(navController: NavController) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 24.dp, vertical = 24.dp),
        horizontalArrangement = Arrangement.End
    ) {
        FloatingActionButton(onClick = { navController.navigate("watch_screen") },
        backgroundColor = MossGreen,
        contentColor = Color.White,
            modifier = Modifier.size(64.dp)
        ) {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = "Icon")
        }
    }
}

@Composable
fun Contents(
    viewModel: MainView,
    navController: NavController ,
    saveList: MutableList<Entry>
){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SetData(viewModel, navController,saveList)
    }
}

@Composable
fun TopBar(text: String){
    Box(
        modifier = Modifier.fillMaxWidth(),
        Alignment.Center
    ){
        Text(
            text = text,
            style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(vertical = 24.dp)
        )
    }
}

@Preview
@Composable
fun Btm(){
    BottomBar(navController = rememberNavController())
}