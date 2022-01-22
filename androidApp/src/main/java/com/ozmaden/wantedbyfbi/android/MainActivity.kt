package com.ozmaden.wantedbyfbi.android

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.ozmaden.wantedbyfbi.android.ui.theme.ComposeTheme
import com.ozmaden.wantedbyfbi.shared.network.WantedApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import androidx.compose.ui.Modifier
import com.ozmaden.wantedbyfbi.android.ui.WantedList

class MainActivity : AppCompatActivity() {
    private val mainScope = MainScope()

    private lateinit var wantedRecyclerView: RecyclerView
    private lateinit var progressBarView: FrameLayout
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    //    private val sdk = WantedSDK(DatabaseDriverFactory(this))
    private val api = WantedApi()

    private val wantedRvAdapter = WantedRvAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "Wanted by the FBI"

//        setContentView(R.layout.activity_main)

//        wantedRecyclerView = findViewById(R.id.wantedListRv)
//        progressBarView = findViewById(R.id.progressBar)
//        swipeRefreshLayout = findViewById(R.id.swipeContainer)

//        wantedRecyclerView.adapter = wantedRvAdapter
//        wantedRecyclerView.layoutManager = LinearLayoutManager(this)

//        swipeRefreshLayout.setOnRefreshListener {
//            swipeRefreshLayout.isRefreshing = false
//            displayWanted(true)
//        }

        displayWanted(false)
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        mainScope.cancel()
//    }

    private fun displayWanted(needReload: Boolean) {
//        progressBarView.isVisible = true
        mainScope.launch {
            kotlin.runCatching {
//                sdk.getPeople(needReload)
                api.getAllPeople()
            }.onSuccess {
                val people = it
                setContent {
                    ComposeTheme {
                        Surface(color = MaterialTheme.colors.background) {
                            WantedList(
                                modifier = Modifier.fillMaxSize(),
                                people,
                            )
                        }
                    }
                }
            }.onFailure {
                Toast.makeText(this@MainActivity, it.localizedMessage, Toast.LENGTH_SHORT).show()
            }
//            progressBarView.isVisible = false
        }
    }
}