package com.ozmaden.wantedbyfbi.shared.network

import com.ozmaden.wantedbyfbi.shared.entity.WantedDatabase
import com.ozmaden.wantedbyfbi.shared.entity.WantedPerson
import io.ktor.client.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class WantedApi {
    private val finalPage = 46

    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            }
            serializer = KotlinxSerializer(json)
        }
    }

    suspend fun getAllPeople(): List<WantedPerson> {
        val all = mutableListOf<List<WantedPerson>>()
        for (i in 1..finalPage) {
            val item = getPeopleFromPage(i)
            all.add(item)
        }
        return all.flatten()
    }

    private suspend fun getPeopleFromPage(page: Int): List<WantedPerson> {
        val db: WantedDatabase = httpClient.get(WANTED_ENDPOINT) {
            parameter("page", page)
        }
        return db.items
    }

    companion object {
        private const val WANTED_ENDPOINT = "https://api.fbi.gov/wanted/v1/list"
    }
}