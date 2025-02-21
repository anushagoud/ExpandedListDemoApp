package com.example.expandedlistdemoapp.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expandedlistdemoapp.data.DataManager
import com.example.expandedlistdemoapp.data.model.StateListModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StateListViewModel @Inject constructor(private val stateData: DataManager) :
    ViewModel() {
    //the list of live data
    var listDataState : MutableList<List<StateListModel>> =  mutableListOf(emptyList<StateListModel>())

    fun fetchStateList()  {
         var responseDataList:List<List<StateListModel>>
        viewModelScope.launch {

            try {
                 responseDataList   = stateData.loadFileFromAssets()
                listDataState = responseDataList.toMutableList()
                Log.e(TAG, responseDataList.toString())
            } catch (e: Exception) {
               e.printStackTrace()
            }
        }
    }
    companion object
    {
        val TAG="StateListViewModel.class"
    }
}
