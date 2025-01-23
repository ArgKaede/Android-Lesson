package com.mokelab.lesson.pokemon.core.data.model

import com.mokelab.lesson.core.network.NetworkPokemon
import com.mokelab.lesson.pokemon.core.model.Pokemon

internal fun NetworkPokemon.toPokemon(): Pokemon {
    return Pokemon(
        id = id,
        name = name
    )
}