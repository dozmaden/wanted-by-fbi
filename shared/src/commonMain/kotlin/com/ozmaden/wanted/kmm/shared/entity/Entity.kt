package com.ozmaden.wanted.kmm.shared.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WantedPerson(
    @SerialName("image")
    val image: String,
    @SerialName("name")
    val name: String,
    @SerialName("aliases")
    val aliases: String,
    @SerialName("nationality")
    val nationality: String,
    @SerialName("race")
    val race: String,
    @SerialName("hair")
    val hair: String,
    @SerialName("height")
    val height: String,
    @SerialName("eyes")
    val eyes: String,
    @SerialName("complexion")
    val complexion: String,
    @SerialName("date_of_birth")
    val date_of_birth: String,
    @SerialName("place_of_birth")
    val place_of_birth: String,
    @SerialName("languages")
    val languages: String,
    @SerialName("possible_countries")
    val possible_countries: String,
    @SerialName("description")
    val description: String,
    @SerialName("remarks")
    val remarks: String,
    @SerialName("caution")
    val caution: String,
    @SerialName("warning_message")
    val warning_message: String
)