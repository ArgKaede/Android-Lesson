package com.mokelab.lesson.pokemon.core.data.model

import com.mokelab.lesson.core.network.NetworkPokemon
import com.mokelab.lesson.pokemon.core.model.Pokemon
import com.mokelab.lesson.pokemon.core.model.PokemonId

internal fun NetworkPokemon.toPokemon(): Pokemon {
    return Pokemon(
        id = PokemonId(value = id / 10),
        name = name
    )
}