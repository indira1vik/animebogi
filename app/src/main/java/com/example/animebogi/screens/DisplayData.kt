package com.example.animebogi.screens

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberImagePainter
import com.example.animebogi.data.AnimeItem
import com.example.animebogi.data.Entry
import com.example.animebogi.data.User
import com.example.animebogi.ui.theme.MossGreen
import com.example.animebogi.ui.theme.PakGreen
import java.lang.Integer.parseInt
import java.util.*
import java.util.logging.Logger.global
import kotlin.collections.ArrayList

@Composable
fun DisplayData(
    animeList: MutableList<Entry>,
    navController: NavController,
    saveList: MutableList<Entry>
) {
    var toSearch = remember { mutableStateOf(TextFieldValue("")) }
    var result: MutableList<Entry> = ArrayList()
    SearchFieldWithIcons(toSearch)
    LazyColumn(
        modifier = Modifier.padding(horizontal = 18.dp)
    ){
        val searchText = toSearch.value.text
        result = if (searchText.isEmpty()) {
            animeList
        } else{
            val resultList = ArrayList<Entry>()
            for (item in animeList) {
                if (item.title!!.lowercase(Locale.getDefault())
                        .contains(searchText.lowercase(Locale.getDefault()))
                ) {
                    resultList.add(item)
                }
            }
            resultList
        }
        items(result){eachFinal->
            CardItem(anime = eachFinal, navController, saveList)
        }
    }
}

@Composable
fun CardItem(anime: Entry,navController: NavController, saveList: MutableList<Entry>) {
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
                Button(onClick = {
                    saveList.add(anime)
                }) {
                    Text(text = "Watch Later")
                }
            }

        }
    }
    Spacer(modifier = Modifier.height(18.dp))
}
