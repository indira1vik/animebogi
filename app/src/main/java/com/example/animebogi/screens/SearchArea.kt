package com.example.animebogi.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.animebogi.data.Entry
import java.util.*
import kotlin.collections.ArrayList

@Composable
fun SearchFieldWithIcons(toSearch: MutableState<TextFieldValue>) {
    OutlinedTextField(
        value = toSearch.value,
        onValueChange = {
            toSearch.value = it
        },
        leadingIcon = { Icon(imageVector = Icons.Rounded.Search, contentDescription = "SearchIcon") },
        modifier = Modifier.fillMaxWidth()
            .padding(18.dp,0.dp,18.dp,18.dp),
        shape = RoundedCornerShape(8.dp),
        singleLine = true,
        placeholder = { Text(text = "Search here") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Black,
            leadingIconColor = Color.Black,
            focusedBorderColor = Color.Black,
            cursorColor = Color.Black
        )
    )
}