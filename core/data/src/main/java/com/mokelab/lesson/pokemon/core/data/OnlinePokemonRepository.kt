package com.mokelab.lesson.pokemon.core.data

import com.mokelab.lesson.core.network.NetworkPokemonDataSource
import com.mokelab.lesson.pokemon.core.data.model.toPokemon
import com.mokelab.lesson.pokemon.core.model.Pokemon
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OnlinePokemonRepository @Inject constructor(
    private val networkDataSource: NetworkPokemonDataSource,
) : PokemonRepository {
    override suspend fun load(): List<Pokemon> {
        return networkDataSource.fetch(System.currentTimeMillis())
            .map { it.toPokemon() }
    }

}