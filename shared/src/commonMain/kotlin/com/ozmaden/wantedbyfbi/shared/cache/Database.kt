package com.ozmaden.wantedbyfbi.shared.cache

import com.ozmaden.wantedbyfbi.shared.cache.DatabaseDriverFactory
//import com.ozmaden.wantedbyfbi.shared.entity.Images
import com.ozmaden.wantedbyfbi.shared.entity.WantedPerson

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
//    private val database = AppDatabase(databaseDriverFactory.createDriver())
//    private val dbQuery = database.appDatabaseQueries
//
//    internal fun clearDatabase() {
//        dbQuery.transaction {
//            dbQuery.removeAllPeople()
//        }
//    }
//
////    internal fun getAllPeople(): List<WantedPerson> {
////        return dbQuery.selectAllPeople(::mapPerson).executeAsList()
////    }
//
//    private fun mapPerson(
//        uid: String
////        name: String?
//    ): WantedPerson {
//        return WantedPerson(
//            uid = uid
////            name = name
//        )
//    }
//
//    internal fun createPeople(people: List<WantedPerson>) {
//        dbQuery.transaction {
//            people.forEach { person ->
//                insertPerson(person)
//            }
//        }
//    }
//
//    private fun insertPerson(person: WantedPerson) {
//        dbQuery.insertPerson(
//            uid = person.uid
////            name = person.name
//        )
//    }
}