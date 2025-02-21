package com.example.expandedlistdemoapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expandedlistdemoapp.data.viewmodels.StateListViewModel
import com.example.expandedlistdemoapp.ui.components.StateListScreen
import com.example.expandedlistdemoapp.ui.theme.ExpandedListDemoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : ComponentActivity() {
    private val stateListViewModel: StateListViewModel by viewModels()

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
                        Scaffold(
                            modifier = Modifier
                                .fillMaxSize()
                                .height(20.dp),

                            topBar = {

                                CenterAlignedTopAppBar(colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.primaryContainer,

                                    ), title = {
                                    Text(
                                        text = "States",
                                        style = MaterialTheme.typography.headlineMedium.copy(
                                            fontWeight = FontWeight.Bold
                                        )
                                    )

                                })

                            })

                        {
                            stateListViewModel.fetchStateList()
                            StateListScreen(stateListViewModel)
                        }
                        ThemeButton()

                    }
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ThemeButton() {
    val checked = true
    Column(
        horizontalAlignment = Alignment.End,
       modifier = Modifier.padding(20.dp)

    ) {
        Switch(checked = checked, onCheckedChange = {
            if (checked)
                ThemeState.isLight = !ThemeState.isLight
            else
                ThemeState.isLight = ThemeState.isLight

        })

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
