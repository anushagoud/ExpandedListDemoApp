package com.example.expandedlistdemoapp.data

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.expandedlistdemoapp.data.model.StateListModel
import com.google.gson.Gson

class DataManager ( val context: Context) {

    var isDataLoaded = mutableStateOf(false)

    fun loadFileFromAssets() : List<List<StateListModel>> {
        val inputStream = context.assets.open("cities.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
       var data = gson.fromJson(json, Array<StateListModel>::class.java).toList()
        isDataLoaded.value = true
        return listOf( data)
    }
}