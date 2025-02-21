package com.example.expandedlistdemoapp.data.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expandedlistdemoapp.data.datasource.DataManager
import com.example.expandedlistdemoapp.data.model.StateListModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StateListViewModel @Inject constructor(private val stateData: DataManager) :
    ViewModel() {

    val _stateList = MutableStateFlow(listOf<StateListModel>())
    val stateList: StateFlow<List<StateListModel>> get() = _stateList

    fun fetchStateList() {
        var responseDataList: List<StateListModel>
        viewModelScope.launch {

            try {
                responseDataList = stateData.loadFileFromAssets()
                _stateList.value = responseDataList
                Log.e(TAG, responseDataList.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    companion object {
        const val TAG = "StateListViewModel.class"
    }
}
