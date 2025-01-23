package com.mokelab.lesson.pokemon.core.model

@JvmInline
value class PokemonId(val value: String)

/**
 * ポケモンを表すクラス
 */
data class Pokemon (
    val id: String,
    val name: String,
) {
    companion object
}