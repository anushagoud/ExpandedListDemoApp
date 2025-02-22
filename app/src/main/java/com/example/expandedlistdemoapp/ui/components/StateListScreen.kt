package com.example.expandedlistdemoapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.expandedlistdemoapp.data.viewmodels.StateListViewModel

@Composable
fun StateListScreen(stateListViewModel: StateListViewModel) {
    val data = stateListViewModel._stateList.collectAsState().value
    var count = 1
    var reversedDataList = data
    var btnClicked by remember { mutableStateOf(false) }
    Column(
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1.7f)
                .padding(10.dp), content = {

                if (btnClicked) {
                    reversedDataList = data.reversed()
                } else {
                    reversedDataList = data
                }

                itemsIndexed(reversedDataList) { index: Int, item ->
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        ), modifier = Modifier.padding(vertical = 5.dp, horizontal = 5.dp)
                    ) {

                        StateListViewScreen(name = item)
                    }
                }
            })

        Column(
            modifier = Modifier
                .weight(0.3f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    count++
                    btnClicked = count % 2 == 0
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.inversePrimary)
            ) {
                Text(
                    text = "Reverse Button",
                    color = Color.Black,
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
                )
            }
        }

    }
}




