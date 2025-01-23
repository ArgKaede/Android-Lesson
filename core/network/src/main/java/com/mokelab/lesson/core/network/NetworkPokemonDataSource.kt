package com.mokelab.lesson.core.network

interface NetworkPokemonDataSource {
    suspend fun fetch(startTimeMillis: Long): List<NetworkPokemon>
}