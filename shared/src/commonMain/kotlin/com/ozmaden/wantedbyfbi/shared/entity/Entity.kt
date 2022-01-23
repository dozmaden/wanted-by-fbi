package com.ozmaden.wantedbyfbi.shared.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WantedDatabase(
    @SerialName("total")
    val total: Int,
    @SerialName("items")
    val items: List<WantedPerson>
)

@Serializable
data class WantedPerson(
    @SerialName("uid")
    val uid: String,
    @SerialName("images")
    val image: List<Images>,
    @SerialName("title")
    val name: String,
    @SerialName("description")
    val description: String? = null,
    @SerialName("date_of_birth")
    val date_of_birth: String? = null,
    @SerialName("place_of_birth")
    val place_of_birth: String? = null,
    @SerialName("hair")
    val hair: String? = null,
    @SerialName("eyes")
    val eyes: String? = null,
    @SerialName("height")
    val height: String? = null,
    @SerialName("weight")
    val weight: String? = null,
    @SerialName("sex")
    val sex: String? = null,
    @SerialName("race")
    val race: String? = null,
    @SerialName("nationality")
    val nationality: String? = null,
    @SerialName("complexion")
    val complexion: String? = null,
    @SerialName("scars_and_marks")
    val scars_and_marks: String? = null,
    @SerialName("reward")
    val reward: String? = null,
    @SerialName("details")
    val details: String? = null,
    @SerialName("remarks")
    val remarks: String? = null,
    @SerialName("caution")
    val caution: String? = null,
    @SerialName("warning_message")
    val warning: String? = null
)

@Serializable
data class Images(
    @SerialName("thumb")
    val thumb: String,
    @SerialName("large")
    val large: String? = null,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("original")
    val original: String? = null
)