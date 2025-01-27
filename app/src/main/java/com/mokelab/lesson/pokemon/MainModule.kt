package com.mokelab.lesson.pokemon

import com.mokelab.lesson.core.network.HttpPokemonDataSource
import com.mokelab.lesson.core.network.NetworkPokemonDataSource
import com.mokelab.lesson.pokemon.core.data.OnlinePokemonRepository
import com.mokelab.lesson.pokemon.core.data.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MainModule {
    @Binds
    @Singleton
    abstract fun bindPokemonRepository(impl: OnlinePokemonRepository): PokemonRepository

    @Binds
    @Singleton
    abstract fun bindNetworkPokemonDataSource(impl: HttpPokemonDataSource): NetworkPokemonDataSource
}

@Module
@InstallIn(SingletonComponent::class)
object ClientModule {
    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(CIO)
    }

    @Provides
    @Named("baseUrl")
    @Singleton
    fun provideBaseUrl(): String {
        return "https://us-central1-trialapp2025-funsite.cloudfunctions.net"
    }
}