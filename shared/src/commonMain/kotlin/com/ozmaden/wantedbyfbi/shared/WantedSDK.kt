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
//        If you change local database, clear the old one and create new one
//        database.clearDatabase()
//        database.createDatabase()
        val cachedPeople = database.getWantedPeople()
        return if (cachedPeople.isNotEmpty() && !forceReload) {
            cachedPeople
        } else {
            api.getAllPeople().also {
                database.clearDatabase()
                database.insertPeople(it)
            }
            database.getWantedPeople()
        }
    }
}