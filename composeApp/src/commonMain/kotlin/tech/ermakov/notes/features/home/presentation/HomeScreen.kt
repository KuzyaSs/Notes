package tech.ermakov.notes.features.home.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.koin.compose.koinInject
import tech.ermakov.notes.core.navigation.Navigator
import tech.ermakov.notes.core.navigation.component.NavigationHandler
import tech.ermakov.notes.core.ui.NotesTheme
import tech.ermakov.notes.features.home.di.homeNavigatorQualifier
import tech.ermakov.notes.features.home.presentation.component.HomeNavigationBar
import tech.ermakov.notes.features.notes.ui.NotesDestination
import tech.ermakov.notes.features.notes.ui.notesDestination
import tech.ermakov.notes.features.toDo.ui.toDoDestination

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
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NotesDestination,
            modifier = Modifier
                .padding(paddingValues = innerPadding),
        ) {
            notesDestination()
            toDoDestination()
        }
    }
}
