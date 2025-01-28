package com.mokelab.lesson.pokemon.core.model

@JvmInline
value class PokemonId(val value: Int)

/**
 * ポケモンを表すクラス
 */
data class Pokemon (
    val id: PokemonId,
    val name: String,
) {
    companion object
}