package com.ozmaden.wantedbyfbi.android.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ozmaden.wantedbyfbi.shared.entity.WantedPerson

@Composable
fun ItemInfo(item: WantedPerson) {
    item.image[0].caption?.let {
        Text(
            text = it, textAlign = TextAlign.Center,
            fontSize = 10.sp, style = MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(1.dp))
    }

    Text(
        text = item.name,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 35.sp,
        style = MaterialTheme.typography.body1,
        textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.height(4.dp))


    item.description?.let {
        val desc = processDescription(it)
        Text(
            text = desc,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            style = MaterialTheme.typography.body2,
        )
        Spacer(modifier = Modifier.height(2.dp))
    }

    item.place_of_birth?.let {
        MapInfo(type = "Place Of Birth", info = it)
    }

    item.date_of_birth?.let {
        MapInfo(type = "Date Of Birth", info = it)
    }

    item.hair?.let {
        MapInfo(type = "Hair", info = it)
    }

    item.eyes?.let {
        MapInfo(type = "Eyes", info = it)
    }

    item.height?.let {
        MapInfo(type = "Height", info = it)
    }

    item.weight?.let {
        MapInfo(type = "Weight", info = it)
    }

    item.sex?.let {
        if (it.contains("Male") || it.contains("Female")) {
            MapInfo(type = "Sex", info = it)
        }
    }

    item.race?.let {
        MapInfo(type = "Race", info = it)
    }

    item.nationality?.let {
        MapInfo(type = "Nationality", info = it)
    }

    item.complexion?.let {
        MapInfo(type = "Complexion", info = it)
    }

    item.scars_and_marks?.let {
        MapInfo(type = "Scars and Marks", info = it)
    }

    item.reward?.let {
        MapInfo(type = "Reward", info = it)
    }

    item.details?.let {
        MapInfo(type = "Details", info = processDescription(it))
    }

    item.remarks?.let {
        MapInfo(type = "Remarks", info = processDescription(it))
    }

    item.caution?.let {
        MapInfo(type = "Caution", info = processDescription(it))
    }

    item.warning?.let {
        Text(
            text = it,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.Red,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun MapInfo(type: String, info: String) {
    val description = "$type: $info"
    val typeIndex = description.indexOf(type)

    Text(
        text = buildAnnotatedString {
            append(description)
            addStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold
                ),
                start = typeIndex,
                end = typeIndex + type.length
            )
        },
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        modifier = Modifier.padding(1.dp)
    )
}