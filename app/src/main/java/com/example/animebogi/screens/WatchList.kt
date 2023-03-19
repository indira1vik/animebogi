package com.example.animebogi.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.animebogi.MainView
import com.example.animebogi.data.Entry
import com.example.animebogi.ui.theme.PakGreen


@Composable
fun WatchList(
    navController: NavController,
    saveList: MutableList<Entry>
){
    val watchScreenName = "Your WatchList"
    Scaffold(topBar = { TopBar(watchScreenName) }) {
        if (saveList.isNotEmpty()){
            DisplaySaved(saveList = saveList)
        } else{
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "No Anime to Watch !!")
            }
        }

    }
}

@Composable
fun DisplaySaved(saveList: MutableList<Entry>){
    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 18.dp)
            .fillMaxWidth()
    ){
        items(saveList){ item ->
            SavedCards(anime = item, saveList)
        }
    }
}

@Composable
fun SavedCards(anime: Entry, saveList: MutableList<Entry>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(236.dp)
            .border(2.dp, PakGreen, RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ){
            Image(
                painter = rememberImagePainter(
                    anime.images!!.jpg!!.large_image_url
                ),
                contentDescription = "Image",
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .width(136.dp)
                    .fillMaxHeight()
                    .border(2.dp, PakGreen, RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(18.dp,0.dp,0.dp,0.dp)
            ){
                Text(
                    text = anime.title!!,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                )

                OutlinedButton(onClick = {
                    saveList.remove(anime)
                }, border = BorderStroke(1.dp, PakGreen)
                ) {
                    Text(text = "Remove it")
                }
            }

        }
    }
    Spacer(modifier = Modifier.height(18.dp))
}
