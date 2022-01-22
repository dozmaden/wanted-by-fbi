package com.ozmaden.wantedbyfbi.android.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ozmaden.wantedbyfbi.shared.entity.WantedPerson

@Composable
fun WantedList(
    modifier: Modifier = Modifier,
    wantedPeople: List<WantedPerson>
) {
    LazyColumn(modifier = modifier) {
        items(wantedPeople) { data ->
            WantedItem(item = data)
        }
    }
}