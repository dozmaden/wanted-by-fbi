package com.ozmaden.wantedbyfbi.android

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.TextFieldValue
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.ozmaden.wantedbyfbi.android.ui.TopBar
import com.ozmaden.wantedbyfbi.android.ui.WantedList
import com.ozmaden.wantedbyfbi.android.ui.theme.ComposeTheme
import com.ozmaden.wantedbyfbi.shared.WantedSDK
import com.ozmaden.wantedbyfbi.shared.cache.DatabaseDriverFactory
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val sdk = WantedSDK(DatabaseDriverFactory(this))
    private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        displayWanted()
    }

    private fun displayWanted() {
        mainScope.launch {
            kotlin.runCatching {
                sdk.getWantedPeople(false)
            }.onSuccess {
                val wantedPeople = it
                setContent {
                    ComposeTheme {
                        Surface(color = MaterialTheme.colors.background) {
                            Scaffold(
                                topBar = { TopBar() }
                            ) {
                                var refreshing by remember { mutableStateOf(false) }
                                LaunchedEffect(refreshing) {
                                    if (refreshing) {
                                        delay(500)
                                        refreshing = false
                                    }
                                }
                                SwipeRefresh(
                                    state = rememberSwipeRefreshState(isRefreshing = refreshing),
                                    onRefresh = { refreshing = true },
                                ) {
                                    WantedList(
                                        modifier = Modifier.fillMaxSize(),
                                        wantedPeople.shuffled()
                                    )
                                }
                            }
                        }
                    }
                }
            }.onFailure {
                Toast.makeText(this@MainActivity, it.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}