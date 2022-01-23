package com.ozmaden.wantedbyfbi.android.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ozmaden.wantedbyfbi.shared.entity.WantedPerson

@Composable
fun WantedList(
    modifier: Modifier = Modifier,
    wantedPeople: List<WantedPerson>
) {
    LazyColumn(modifier = modifier) {
        items(wantedPeople) { data ->
            WantedItem(item = data)
            Spacer(modifier = Modifier.height(10.dp))
            Divider(modifier = Modifier.height(1.dp), color = Color.Gray, thickness = 1.dp)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}