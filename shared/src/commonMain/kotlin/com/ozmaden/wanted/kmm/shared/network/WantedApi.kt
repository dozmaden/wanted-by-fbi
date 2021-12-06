package com.ozmaden.wanted.kmm.shared.network

import com.ozmaden.wanted.kmm.shared.entity.WantedPerson
import io.ktor.client.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class WantedApi {
    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            }
            serializer = KotlinxSerializer(json)
        }
    }

    suspend fun getAllLaunches(): List<WantedPerson> {
        return httpClient.get(WANTED_ENDPOINT)
    }

    companion object {
        private const val WANTED_ENDPOINT = "https://api.fbi.gov/wanted/v1/list"
    }
}

