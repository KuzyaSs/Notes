package tech.ermakov.notes.features.home.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.koin.compose.koinInject
import tech.ermakov.notes.core.navigation.Navigator
import tech.ermakov.notes.core.navigation.components.NavigationHandler
import tech.ermakov.notes.core.ui.NotesTheme
import tech.ermakov.notes.features.home.di.homeNavigatorQualifier
import tech.ermakov.notes.features.home.presentation.components.HomeNavigationBar
import tech.ermakov.notes.features.notes.NotesDestination
import tech.ermakov.notes.features.notes.notesDestination
import tech.ermakov.notes.features.toDo.toDoDestination

@Composable
internal fun HomeScreen() {
    val homeNavigator = koinInject<Navigator>(qualifier = homeNavigatorQualifier)
    val navController = rememberNavController()

    NavigationHandler(
        navigator = homeNavigator,
        navController = navController,
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            HomeNavigationBar(homeNavigator = homeNavigator, navController = navController)
        },
        containerColor = NotesTheme.colors.backgroundSecondary,
    ) {
        NavHost(
            navController = navController,
            startDestination = NotesDestination,
        ) {
            notesDestination()
            toDoDestination()
        }
    }
}
