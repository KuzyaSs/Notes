package tech.ermakov.notes.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import tech.ermakov.notes.core.navigation.Navigator
import tech.ermakov.notes.core.navigation.component.NavigationHandler
import tech.ermakov.notes.core.ui.NotesTheme
import tech.ermakov.notes.features.home.presentation.HomeDestination
import tech.ermakov.notes.features.home.presentation.homeDestination
import tech.ermakov.notes.features.noteEditor.ui.noteEditorDestination

@Preview
@Composable
internal fun App() = NotesTheme {
    Surface(color = NotesTheme.colors.backgroundPrimary) {
        NotesNavigation()
    }
}

@Composable
private fun NotesNavigation() {
    val navigator = koinInject<Navigator>()
    val navController = rememberNavController()

    NavigationHandler(
        navigator = navigator,
        navController = navController,
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = NotesTheme.colors.backgroundPrimary,
    ) {
        NavHost(
            navController = navController,
            startDestination = HomeDestination,
        ) {
            homeDestination()
            noteEditorDestination()
        }
    }
}
