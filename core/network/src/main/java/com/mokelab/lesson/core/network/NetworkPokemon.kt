package com.mokelab.lesson.core.network

import kotlinx.serialization.Serializable

@Serializable
data class NetworkPokemon(
    val id: Int,
    val name: String,
)