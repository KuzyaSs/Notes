package tech.ermakov.notes.features.home.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object HomeDestination

fun NavGraphBuilder.homeDestination() {
    composable<HomeDestination> {
        HomeScreen()
    }
}
