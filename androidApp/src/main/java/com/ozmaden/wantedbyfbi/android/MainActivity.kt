package com.ozmaden.wantedbyfbi.android

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.ozmaden.wantedbyfbi.android.ui.WantedList
import com.ozmaden.wantedbyfbi.android.ui.theme.ComposeTheme
import com.ozmaden.wantedbyfbi.shared.entity.WantedPerson
import com.ozmaden.wantedbyfbi.shared.network.WantedApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val mainScope = MainScope()

    //    private val sdk = WantedSDK(DatabaseDriverFactory(this))
    private val api = WantedApi()

    lateinit var wanted: List<WantedPerson>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "Wanted by the FBI"

        displayWanted()
    }

    private fun displayWanted() {
        mainScope.launch {
            kotlin.runCatching {
//                sdk.getPeople(needReload)
                api.getAllPeople()
            }.onSuccess {
                setContent {
                    ComposeTheme {
                        Surface(color = MaterialTheme.colors.background) {
                            var refreshing by remember { mutableStateOf(false) }
                            LaunchedEffect(refreshing) {
                                if (refreshing) {
                                    delay(3000)
                                    refreshing = false
                                }
                            }
                            SwipeRefresh(
                                state = rememberSwipeRefreshState(isRefreshing = refreshing),
                                onRefresh = { refreshing = true },
                            ) {
                                WantedList(
                                    modifier = Modifier.fillMaxSize(),
                                    it.flatten().shuffled(),
                                )
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
