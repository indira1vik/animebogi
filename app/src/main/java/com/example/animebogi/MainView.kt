package com.example.animebogi

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.animebogi.data.Anime
import com.example.animebogi.data.AnimeItem
import com.example.animebogi.data.Entry
import com.example.animebogi.sealed.DataState
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce

class MainView: ViewModel() {
    val response: MutableState<DataState> = mutableStateOf(DataState.Empty)

    init{
        fetchDataFromFireBase()
    }

    private val allList = mutableListOf<Entry>()
    private fun fetchDataFromFireBase() {
        val tempList = mutableListOf<AnimeItem>()
        response.value = DataState.Loading

        FirebaseDatabase
            .getInstance()
            .getReference("/")
            .addListenerForSingleValueEvent(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for(EachData in snapshot.children){
                        val animeList = EachData.getValue(AnimeItem::class.java)
                        if (animeList != null){
                            tempList.add(animeList)
                        }
                    }
                    for (i in tempList){
                        if (!allList.contains(i.entry?.get(0)!!)) {
                            allList.add(i.entry?.get(0)!!)
                        }
                        if (!allList.contains(i.entry?.get(1)!!)) {
                            allList.add(i.entry?.get(1)!!)
                        }
                    }
                    response.value = DataState.Success(tempList)
                }

                override fun onCancelled(error: DatabaseError) {
                    response.value = DataState.Failure(error.message)
                }

            })
    }

}