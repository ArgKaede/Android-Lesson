package com.mokelab.lesson.core.network

import javax.inject.Inject

class MockPokemonDataSource @Inject constructor() : NetworkPokemonDataSource {
    override suspend fun fetch(startTimeMillis: Long): List<NetworkPokemon> {
        return listOf(
            NetworkPokemon(
                id = "30",
                name = "フシギバナ",
                createdAtMillis = 1736730000000L,
            ),
            NetworkPokemon(
                id = "60",
                name = "リザードン",
                createdAtMillis = 1736211600000L,
            ),
        )
    }
}