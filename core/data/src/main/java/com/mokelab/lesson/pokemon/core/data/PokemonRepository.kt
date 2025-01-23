package com.mokelab.lesson.pokemon.core.data

import com.mokelab.lesson.pokemon.core.model.Pokemon

interface PokemonRepository {
    suspend fun load(): List<Pokemon>
//    suspend fun fetchList(key: String): FetchListResult
//}
//
//data class FetchListResult(
//    val result: List<Pokemon>,
//    val nextKey: String? = null
//) {
//    companion object {
//        val EMPTY = FetchListResult(emptyList())
//    }
}
