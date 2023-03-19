package com.example.animebogi.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.animebogi.sealed.DataState
import com.example.animebogi.MainView
import com.example.animebogi.data.Entry

@Composable
fun SetData(viewModel: MainView, navController: NavController,saveList: MutableList<Entry>) {
    when (val result = viewModel.response.value){
        is DataState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), Alignment.Center){
                CircularProgressIndicator()
            }
        }
        is DataState.Failure -> {
            Box(modifier = Modifier.fillMaxSize(), Alignment.Center){
                Text(text = result.message, style = TextStyle(fontSize = 24.sp))
            }
        }
        is DataState.Success -> {
            val finalList = mutableListOf<Entry>()
            for (i in result.data){
                if (!finalList.contains(i.entry?.get(0)!!)){
                    finalList.add(i.entry?.get(0)!!)
                }
                if (!finalList.contains(i.entry?.get(1)!!)){
                    finalList.add(i.entry?.get(1)!!)
                }
            }
            DisplayData(animeList = finalList, navController = navController,saveList)
        }
        else -> {
            Box(modifier = Modifier.fillMaxSize(), Alignment.Center){
                Text(text = "Error in Fetching Data", style = TextStyle(fontSize = 24.sp))
            }
        }
    }
}