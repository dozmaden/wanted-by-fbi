package com.ozmaden.wantedbyfbi.android.ui

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.ozmaden.wantedbyfbi.android.R

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name), fontSize = 18.sp) },
        backgroundColor = colorResource(id = R.color.colorPrimary),
        contentColor = Color.White,
    )
}