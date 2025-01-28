import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mokelab.lesson.core.design.ProgressIndicator
import com.mokelab.lesson.core.design.Screen
import com.mokelab.lesson.core.design.theme.PokemonListTheme
import com.mokelab.lesson.pokemon.core.model.Pokemon
import com.mokelab.lesson.pokemon.core.model.PokemonId
import com.mokelab.lesson.pokemon.core.ui.PokemonItem
import com.mokelab.lesson.pokemon.feature.pokemon.PokemonListViewModel as PokemonListViewModel1

@Composable
fun PokemonListScreen(
    viewModel: PokemonListViewModel1,
    modifier: Modifier = Modifier,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    PokemonListScreen(
        uiState = uiState,
        load = { viewModel.load() },
        modifier = modifier,
    )
}

@Composable
private fun PokemonListScreen(
    uiState: PokemonListViewModel1.UiState,
    load: () -> Unit,
    modifier: Modifier,
) {
    Screen(
        modifier = modifier,
    ) { paddingValues ->
        when (uiState) {
            PokemonListViewModel1.UiState.Initial,
            PokemonListViewModel1.UiState.Loading -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                ) {
                    ProgressIndicator()
                }
            }

            is PokemonListViewModel1.UiState.Success -> {
                PokemonList(
                    pokemons = uiState.pokemons,
                    modifier = Modifier.padding(paddingValues),
                )
            }

            is PokemonListViewModel1.UiState.Error -> {}
        }
    }

    LaunchedEffect(uiState) {
        when (uiState) {
            PokemonListViewModel1.UiState.Initial -> {
                load()
            }

            PokemonListViewModel1.UiState.Loading -> Unit
            is PokemonListViewModel1.UiState.Success -> Unit
            is PokemonListViewModel1.UiState.Error -> Unit
        }
    }
}

@Composable
private fun PokemonList(
    pokemons: List<Pokemon>,
    modifier: Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        items(pokemons) { pokemon ->
            if (pokemon == null) {
                ProgressIndicator()
                return@items
            }
            PokemonItem(pokemon = pokemon)
        }
    }
}

@Preview
@Composable
private fun Preview() {
    PokemonListTheme {
        PokemonListScreen(
            uiState = PokemonListViewModel1.UiState.Success(
                pokemons = listOf(
                    Pokemon(
                        id = PokemonId(3),
                        name = "フシギバナ",
                    ),
                    Pokemon(
                        id = PokemonId(6),
                        name = "リザードン",
                    ),
                )
            ),
            load = {},
            modifier = Modifier,
        )
    }
}