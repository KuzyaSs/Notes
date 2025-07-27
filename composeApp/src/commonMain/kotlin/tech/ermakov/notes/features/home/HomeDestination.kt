package tech.ermakov.notes.features.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import org.koin.compose.koinInject
import tech.ermakov.notes.core.navigation.Navigator
import tech.ermakov.notes.core.navigation.components.NavigationHandler
import tech.ermakov.notes.features.home.di.homeNavigatorQualifier
import tech.ermakov.notes.features.notes.NotesDestination
import tech.ermakov.notes.features.notes.notesDestination
import tech.ermakov.notes.features.toDo.toDoDestination

@Serializable
object HomeDestination

fun NavGraphBuilder.homeDestination() {
    composable<HomeDestination> {
        val homeNavigator = koinInject<Navigator>(qualifier = homeNavigatorQualifier)
        val navController = rememberNavController()

        NavigationHandler(
            navigator = homeNavigator,
            navController = navController,
        )

        NavHost(
            navController = navController,
            startDestination = NotesDestination,
        ) {
            notesDestination()
            toDoDestination()
        }
    }
}
