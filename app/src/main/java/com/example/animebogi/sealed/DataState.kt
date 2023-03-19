package com.example.animebogi.sealed

import com.example.animebogi.data.AnimeItem

sealed class DataState{
    class Success(val data: MutableList<AnimeItem>):DataState()
    class Failure(val message: String):DataState()
    object Loading:DataState()
    object Empty:DataState()
}