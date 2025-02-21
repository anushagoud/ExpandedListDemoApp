package com.example.expandedlistdemoapp.data.datasource

import android.content.Context
import com.example.expandedlistdemoapp.data.model.StateListModel
import com.google.gson.Gson

class DataManager(private val context: Context) {

    fun loadFileFromAssets(): List<StateListModel> {
        val inputStream = context.assets.open("cities.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        val data = gson.fromJson(json, Array<StateListModel>::class.java).toList()
        return data
    }
}