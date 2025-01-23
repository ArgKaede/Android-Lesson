package com.mokelab.lesson.core.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkPokemon(
    val id: String,
    val name: String,

    @SerialName("created") val createdAtMillis: Long,
)