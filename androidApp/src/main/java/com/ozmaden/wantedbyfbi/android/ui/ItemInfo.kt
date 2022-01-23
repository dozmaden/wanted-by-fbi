package com.ozmaden.wantedbyfbi.android.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ozmaden.wantedbyfbi.shared.entity.WantedPerson

@Composable
fun ItemInfo(item : WantedPerson) {
    item.image[0].caption?.let {
        Text(
            text = it, textAlign = TextAlign.Center,
            fontSize = 15.sp, style = MaterialTheme.typography.subtitle2
        )
    }
    Text(
        text = item.name, textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold, fontSize = 20.sp,
        style = MaterialTheme.typography.subtitle2
    )
    item.description?.let { Text(text = processDescription(it)) }
    item.place_of_birth?.let { Text(text = it) }
    item.date_of_birth?.let { Text(text = it) }
    item.hair?.let { Text(text = it) }
    item.eyes?.let { Text(text = it) }
    item.height?.let { Text(text = it) }
    item.weight?.let { Text(text = it) }
    item.sex?.let { Text(text = it) }
    item.race?.let { Text(text = it) }
    item.nationality?.let { Text(text = it) }
    item.complexion?.let { Text(text = it) }
    item.scars_and_marks?.let { Text(text = it) }
    item.reward?.let { Text(text = it) }
    item.details?.let { Text(text = processDescription(it)) }
    Spacer(modifier = Modifier.height(4.dp))
    item.remarks?.let { Text(text = processDescription(it)) }
    item.caution?.let { Text(text = processDescription(it)) }
    item.warning?.let { Text(text = it) }
}