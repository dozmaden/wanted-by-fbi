package com.ozmaden.wantedbyfbi.android.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ozmaden.wantedbyfbi.shared.entity.WantedPerson

@Composable
fun WantedItem(item: WantedPerson) {


    Text(text = item.name)


}
