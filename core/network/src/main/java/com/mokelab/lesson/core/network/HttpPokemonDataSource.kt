package com.mokelab.lesson.core.network

import com.mokelab.lesson.core.network.model.NetworkException
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.Url
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class HttpPokemonDataSource @Inject constructor(
    private val client: HttpClient,
) : NetworkPokemonDataSource {
    override suspend fun fetch(startTimeMillis: Long): List<NetworkPokemon> {
        val resp = client.get(Url("https://moke-battle-log.web.app/poke-ja.json"))
        if (resp.status.value != 200) {
            throw NetworkException(
                status = resp.status.value,
                body = resp.body(),
            )
        }
        val respBody: FetchResponse = Json.decodeFromString(resp.body())
        return respBody.pokemons
    }
}

@Serializable
private class FetchResponse(
    val pokemons: List<NetworkPokemon>
)