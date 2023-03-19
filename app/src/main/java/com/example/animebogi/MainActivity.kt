package com.example.animebogi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.example.animebogi.data.Entry
import com.example.animebogi.navigation.NavGraph
import com.example.animebogi.ui.theme.AnimeBogiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel: MainView by viewModels()
        super.onCreate(savedInstanceState)
        setContent {
            AnimeBogiTheme {
                NavGraph(viewModel = viewModel)
            }
        }
    }
}