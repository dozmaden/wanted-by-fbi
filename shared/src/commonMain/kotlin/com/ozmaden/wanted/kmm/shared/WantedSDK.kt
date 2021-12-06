package com.ozmaden.wanted.kmm.shared

import com.ozmaden.wanted.kmm.shared.cache.Database
import com.ozmaden.wanted.kmm.shared.cache.DatabaseDriverFactory
import com.ozmaden.wanted.kmm.shared.entity.WantedPerson
import com.ozmaden.wanted.kmm.shared.network.WantedApi

class WantedSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)
    private val api = WantedApi()

    @Throws(Exception::class)
    suspend fun getPeople(forceReload: Boolean): List<WantedPerson> {
        val cachedPeople = database.getAllPeople()

        return if (cachedPeople.isNotEmpty() && !forceReload) {
            cachedPeople
        } else {
            api.getAllLaunches().also {
                database.clearDatabase()
                database.createPeople(it)
            }
        }
    }
}
