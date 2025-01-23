package com.mokelab.lesson.core.network

import javax.inject.Inject

class MockPokemonDataSource @Inject constructor() : NetworkPokemonDataSource {
    override suspend fun fetch(startTimeMillis: Long): List<NetworkPokemon> {
        return listOf(
            NetworkPokemon(
                id = "30",
                name = "フシギバナ",
            ),
            NetworkPokemon(
                id = "60",
                name = "リザードン",
            ),
        )
    }
}