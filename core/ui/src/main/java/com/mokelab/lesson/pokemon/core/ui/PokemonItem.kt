package com.mokelab.lesson.pokemon.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mokelab.lesson.core.design.theme.TextListItem
import com.mokelab.lesson.pokemon.core.model.Pokemon

@Composable
fun PokemonItem(
    pokemon: Pokemon,
    modifier: Modifier = Modifier,
) {
    TextListItem(
        headline = pokemon.id,
        trailing = pokemon.name,
        modifier = modifier,
    )
}