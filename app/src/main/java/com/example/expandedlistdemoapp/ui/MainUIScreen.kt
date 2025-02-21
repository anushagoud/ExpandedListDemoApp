package com.example.expandedlistdemoapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.expandedlistdemoapp.data.model.StateListModel
import com.example.expandedlistdemoapp.ui.components.StateListScreen
import com.example.expandedlistdemoapp.ui.viewmodels.StateListViewModel


@Composable
fun MainUIScreen(stateListViewModel: StateListViewModel) {

    var checked=true
    Column(
        modifier = Modifier.padding(10.dp)
    ) {

        Switch(checked = checked, onCheckedChange = {
            if(checked)
                ThemeState.isLight = !ThemeState.isLight
            else
                ThemeState.isLight=ThemeState.isLight

        })
        Column {

                StateListScreen(stateListViewModel)

        }

    }
}


