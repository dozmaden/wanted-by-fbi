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

    internal fun createDatabase() {
        dbQuery.transaction {
            dbQuery.createDatabase()
        }
    }

    internal fun insertPeople(people: List<WantedPerson>) {
        dbQuery.transaction {
            people.forEach { person ->
                insertPerson(person)
            }
        }
    }

    private fun insertPerson(person: WantedPerson) {
        dbQuery.insertPerson(
            uid = person.uid,
            thumb = person.image[0].thumb,
            large = person.image[0].large,
            caption = person.image[0].caption,
            original = person.image[0].original,
            name = person.name,
            description = person.description,
            date_of_birth = person.date_of_birth,
            place_of_birth = person.place_of_birth,
            hair = person.hair,
            eyes = person.eyes,
            height = person.height,
            weight = person.weight,
            sex = person.sex,
            nationality = person.nationality,
            complexion = person.complexion,
            scars_and_marks = person.scars_and_marks,
            reward = person.reward,
            details = person.details,
            remarks = person.remarks,
            caution = person.caution,
            warning = person.warning
        )
    }

    internal fun getWantedPeople(): List<WantedPerson> {
        return dbQuery.selectAllPeople(::mapPerson).executeAsList()
    }

    private fun mapPerson(
        uid: String,
        thumb: String,
        large: String?,
        caption: String?,
        original: String?,
        name: String,
        description: String?,
        date_of_birth: String?,
        place_of_birth: String?,
        hair: String?,
        eyes: String?,
        height: String?,
        weight: String?,
        sex: String?,
        nationality: String?,
        complexion: String?,
        scars_and_marks: String?,
        reward: String?,
        details: String?,
        remarks: String?,
        caution: String?,
        warning: String?
    ): WantedPerson {
        return WantedPerson(
            uid = uid,
            image = listOf(Images(thumb, large, caption, original)),
            name = name,
            description = description,
            date_of_birth = date_of_birth,
            place_of_birth = place_of_birth,
            hair = hair,
            eyes = eyes,
            height = height,
            weight = weight,
            sex = sex,
            nationality = nationality,
            complexion = complexion,
            scars_and_marks = scars_and_marks,
            reward = reward,
            details = details,
            remarks = remarks,
            caution = caution,
            warning = warning
        )
    }
}