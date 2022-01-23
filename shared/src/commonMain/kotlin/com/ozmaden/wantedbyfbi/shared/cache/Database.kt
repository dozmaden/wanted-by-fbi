package com.ozmaden.wantedbyfbi.shared.cache

import com.ozmaden.wantedbyfbi.shared.entity.Images
import com.ozmaden.wantedbyfbi.shared.entity.WantedPerson

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun clearDatabase() {
        dbQuery.transaction {
            dbQuery.removeAllPeople()
        }
    }

    internal fun getWantedPeople(): List<WantedPerson> {
        return dbQuery.selectAllPeople(::mapPerson).executeAsList()
    }

    private fun mapPerson(
        uid: String,
        image: String,
        name: String,
        description: String?,
        remarks: String?
    ): WantedPerson {
        return WantedPerson(
            uid = uid,
            image = listOf(Images(image)),
            name = name,
            description = description,
            remarks = remarks
        )
    }

    internal fun createPeople(people: List<WantedPerson>) {
        dbQuery.transaction {
            people.forEach { person ->
                insertPerson(person)
            }
        }
    }

    private fun insertPerson(person: WantedPerson) {
        dbQuery.insertPerson(
            uid = person.uid,
            image = person.image[0].thumb,
            name = person.name,
            description = person.description,
            remarks = person.remarks
        )
    }
}