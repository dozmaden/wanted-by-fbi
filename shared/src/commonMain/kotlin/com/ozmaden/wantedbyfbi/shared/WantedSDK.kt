package com.ozmaden.wantedbyfbi.shared

import com.ozmaden.wantedbyfbi.shared.cache.Database
import com.ozmaden.wantedbyfbi.shared.cache.DatabaseDriverFactory
import com.ozmaden.wantedbyfbi.shared.entity.WantedPerson
import com.ozmaden.wantedbyfbi.shared.network.WantedApi

class WantedSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)
    private val api = WantedApi()

    @Throws(Exception::class)
    suspend fun getWantedPeople(forceReload: Boolean): List<WantedPerson> {
        val cachedPeople = database.getWantedPeople()
        return if (cachedPeople.isNotEmpty() && !forceReload) {
            cachedPeople
        } else {
            api.getAllPeople().also {
                database.clearDatabase()
                database.createPeople(it)
            }
            database.getWantedPeople()
        }
    }
}