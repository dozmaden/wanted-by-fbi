package com.ozmaden.wanted.kmm.shared.cache

import com.ozmaden.wanted.kmm.shared.entity.WantedPerson

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun clearDatabase() {
        dbQuery.transaction {
            dbQuery.removeAllPeople()
        }
    }

    internal fun getAllPeople(): List<WantedPerson> {
        return dbQuery.selectPeople(::mapPerson).executeAsList()
    }

    private fun mapPerson(
        image: String,
        name: String,
        aliases: String,
        nationality: String,
        race: String,
        hair: String,
        height: String,
        eyes: String,
        complexion: String,
        date_of_birth: String,
        place_of_birth: String,
        languages: String,
        possible_countries: String,
        description: String,
        remarks: String,
        caution: String,
        warning_message: String,
    ): WantedPerson {
        return WantedPerson(
            image = image,
            name = name,
            aliases = aliases,
            nationality = nationality,
            race = race,
            hair = hair,
            height = height,
            eyes = eyes,
            complexion = complexion,
            date_of_birth = date_of_birth,
            place_of_birth = place_of_birth,
            languages = languages,
            possible_countries = possible_countries,
            description = description,
            remarks = remarks,
            caution = caution,
            warning_message = warning_message
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
            image = person.image,
            name = person.name,
            aliases = person.aliases,
            nationality = person.nationality,
            race = person.race,
            hair = person.hair,
            height = person.height,
            eyes = person.eyes,
            complexion = person.complexion,
            dateOfBirth = person.date_of_birth,
            placeOfBirth = person.place_of_birth,
            languages = person.languages,
            possibleCountries = person.possible_countries,
            description = person.description,
            remarks = person.remarks,
            caution = person.caution,
            warningMessage = person.warning_message
        )
    }
}