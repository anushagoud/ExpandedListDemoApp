package com.example.expandedlistdemoapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import com.example.expandedlistdemoapp.data.DataManager
import com.example.expandedlistdemoapp.ui.theme.ExpandedListDemoAppTheme
import com.example.expandedlistdemoapp.ui.viewmodels.StateListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
     private val stateListViewModel:StateListViewModel by viewModels()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExpandedListDemoAppTheme {
                MyAppTheme(children = {
                    Surface(
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Scaffold(topBar = {
                            CenterAlignedTopAppBar(colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,

                                ), title = {
                                Text(
                                    text = "CityList",
                                    style = MaterialTheme.typography.headlineMedium.copy(
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            })

                        }){}
                        stateListViewModel.fetchStateList()
                        MainUIScreen(stateListViewModel)
                    }
                })
            }
        }
    }
}

@Composable
fun MyAppTheme(
    children: @Composable() () -> Unit
) {

    if (ThemeState.isLight) {
        MaterialTheme(lightColorScheme()) {
            children()
        }
    } else {
        MaterialTheme(darkColorScheme()) {
            children()
        }

    }
}

object ThemeState {
    var isLight by mutableStateOf(true)
}
