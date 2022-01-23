package com.ozmaden.wantedbyfbi.android.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.ozmaden.wantedbyfbi.shared.entity.WantedPerson

@Composable
fun WantedItem(item: WantedPerson) {
    Row {

        Column(verticalArrangement = Arrangement.Center) {
            Image(
                painter = rememberImagePainter(item.image[0].thumb),
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = item.name, textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold, fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            item.description?.let { Text(text = processInfo(it, 100)) }
//            item.place_of_birth?.let { Text(text = it) }
//            item.date_of_birth?.let { Text(text = it) }
//            item.hair?.let { Text(text = it) }
//            item.eyes?.let { Text(text = it) }
//            item.height?.let { Text(text = it) }
//            item.weight?.let { Text(text = it) }
//            item.sex?.let { Text(text = it) }
//            item.race?.let { Text(text = it) }
//            item.nationality?.let { Text(text = it) }
//            item.complexion?.let { Text(text = it) }
//            item.scars_and_marks?.let { Text(text = it) }
//            item.reward?.let { Text(text = it) }
//            item.details?.let { Text(text = it.replace("<p>", "").replace("</p>", "")) }
            Spacer(modifier = Modifier.height(4.dp))
            item.remarks?.let { Text(text = processInfo(it, 70)) }
//            item.caution?.let { Text(text = it.replace("<p>", "").replace("</p>", "")) }
//            item.warning?.let { Text(text = it) }
        }
    }
}

fun processInfo(info: String, limit: Int): String {
    val result = info.replace("<p>", "").replace("</p>", "")
    return if (info.length <= limit) {
        result
    } else {
        result.take(limit).plus("...")
    }
}