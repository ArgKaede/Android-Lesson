package com.mokelab.lesson.core.network

import com.mokelab.training.app2025.core.network.model.NetworkPokemon

interface NetworkPokemonDataSource {
    suspend fun fetch(startTimeMillis: Long): List<NetworkPokemon>
}