package com.ozmaden.wantedbyfbi.android.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.ozmaden.wantedbyfbi.shared.entity.WantedPerson

@Composable
fun WantedItem(item: WantedPerson) {
    Row(modifier = Modifier.padding(all = 8.dp)) {

        var imageExpanded by remember { mutableStateOf(false) }
        Column(modifier = Modifier.clickable { imageExpanded = !imageExpanded }) {

            Image(
                painter = if (!imageExpanded) rememberImagePainter(item.image[0].thumb)
                else rememberImagePainter(item.image[0].large),
                contentDescription = item.image[0].caption,
                modifier = if (!imageExpanded) Modifier.size(128.dp)
                else Modifier.size(512.dp)
            )

            if (imageExpanded) {
                ItemInfo(item = item)
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        var infoExpanded by remember { mutableStateOf(false) }

        if (!imageExpanded) {
            Column(modifier = Modifier.clickable { infoExpanded = !infoExpanded }) {
                Text(
                    text = item.name,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.body1
                )

                Spacer(modifier = Modifier.height(4.dp))

                item.description?.let {
                    val desc = processDescription(it)
                    Text(
                        text = if (!infoExpanded && desc.length > 75) "${desc.take(75)}..."
                        else desc,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = if (!infoExpanded) 4 else Int.MAX_VALUE,
                        style = MaterialTheme.typography.subtitle1
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                item.remarks?.let {
                    val remarks = processDescription(it)
                    Text(
                        text = if (!infoExpanded && remarks.length > 50) "${remarks.take(50)}..."
                        else remarks,
                        fontWeight = FontWeight.Normal,
                        maxLines = if (!infoExpanded) 2 else Int.MAX_VALUE,
                        style = MaterialTheme.typography.subtitle2
                    )
                }
            }
        }
    }
}

fun processDescription(info: String): String {
    return info.replace("<p>", "").replace("</p>", "")
        .replace("<br />", "")
}