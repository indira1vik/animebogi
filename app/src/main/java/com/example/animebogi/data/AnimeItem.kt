package com.example.animebogi.data

data class AnimeItem(
    var content: String? = null,
    var date: String?= null,
    var entry: List<Entry>? = null,
    var mal_id: String? = null,
    var user: User? = null
)