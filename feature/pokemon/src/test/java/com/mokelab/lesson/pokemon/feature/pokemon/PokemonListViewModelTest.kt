package com.mokelab.lesson.pokemon.feature.pokemon


import com.mokelab.lesson.pokemon.core.data.PokemonRepository
import io.mockk.coEvery
import io.mockk.mockk
import com.mokelab.lesson.pokemon.core.model.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class PokemonListViewModelTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testLoadSuccess() = runTest {
        val repo = mockk<PokemonRepository>()
        val viewModel = PokemonListViewModel(
            pokemonRepository = repo,
        )

        coEvery { repo.load() } returns listOf(
            Pokemon(
                id = "30",
                name = "フシギバナ"
            )
        )

        assertThat(
            viewModel.uiState.value,
            instanceOf(PokemonListViewModel.UiState.Initial::class.java)
        )
        viewModel.load()
        advanceUntilIdle()
        assertThat(
            viewModel.uiState.value,
            instanceOf(PokemonListViewModel.UiState.Success::class.java)
        )
        val pokemons = (viewModel.uiState.value as PokemonListViewModel.UiState.Success)
            .pokemons
        assertThat(pokemons.size, `is`(1))

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testLoadErrorSuccess() = runTest {
        val repo = mockk<PokemonRepository>()
        val viewModel = PokemonListViewModel(
            pokemonRepository = repo,
        )

        coEvery { repo.load() } throws Exception("Failed to load")

        assertThat(
            viewModel.uiState.value,
            instanceOf(PokemonListViewModel.UiState.Initial::class.java)
        )
        viewModel.load()
        advanceUntilIdle()
        assertThat(
            viewModel.uiState.value,
            instanceOf(PokemonListViewModel.UiState.Error::class.java)
        )
        val exception = (viewModel.uiState.value as PokemonListViewModel.UiState.Error)
            .th
        assertThat(exception, instanceOf(Exception::class.java))

        // retry

        coEvery { repo.load() } returns listOf(
            Pokemon(
                id = "30",
                name = "フシギバナ"
            )
        )
        viewModel.load()
        advanceUntilIdle()
        assertThat(
            viewModel.uiState.value,
            instanceOf(PokemonListViewModel.UiState.Success::class.java)
        )
        val pokemons = (viewModel.uiState.value as PokemonListViewModel.UiState.Success)
            .pokemons
        assertThat(pokemons.size, `is`(1))
    }
}