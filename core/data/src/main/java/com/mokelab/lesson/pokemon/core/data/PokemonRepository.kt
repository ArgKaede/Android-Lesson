package com.mokelab.lesson.pokemon.core.data

import com.mokelab.lesson.pokemon.core.model.Pokemon

interface PokemonRepository {
    suspend fun load(): List<Pokemon>
}
