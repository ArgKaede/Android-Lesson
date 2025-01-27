package com.mokelab.lesson.pokemon

import PokemonListScreen
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import com.mokelab.lesson.core.design.theme.PokemonListTheme
import com.mokelab.lesson.pokemon.feature.pokemon.PokemonListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokemonListTheme {
                val viewModel: PokemonListViewModel = hiltViewModel()
                PokemonListScreen(viewModel)
            }
        }
    }
}