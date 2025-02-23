package com.example.expandedlistdemoapp.ui.components


import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.expandedlistdemoapp.data.datasource.Constant
import com.example.expandedlistdemoapp.data.model.StateListModel


@Composable
fun StateListViewScreen(name: StateListModel) {
    var expanded by remember { mutableStateOf(false) }
    var const =Constant()
    Row(
        modifier = Modifier
            .padding(const.small)
            .animateContentSize()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(const.small)
        ) {
            name.adminName?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
                )
            }
            if (expanded) {
                Column(

                ) {
                    Text(text = name.capital)
                    Text(text = name.iso2)
                    Text(text = name.city)
                }
            }
        }

        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) {
                    Icons.Filled.ExpandLess
                } else Icons.Filled.ExpandMore,
                contentDescription =
                if (expanded) {
                    "show less"
                } else {
                    "show more"
                }
            )
        }
    }
}