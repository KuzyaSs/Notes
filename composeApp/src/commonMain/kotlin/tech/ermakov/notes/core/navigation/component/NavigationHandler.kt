package tech.ermakov.notes.core.navigation.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import tech.ermakov.notes.core.navigation.Navigator
import tech.ermakov.notes.core.navigation.model.NavigatorAction

@Composable
fun NavigationHandler(
    navigator: Navigator,
    navController: NavController
) {
    val action = navigator.action.collectAsStateWithLifecycle(null).value

    LaunchedEffect(action) {
        when (action) {
            is NavigatorAction.Back -> {
                navController.navigateUp()
            }

            is NavigatorAction.Navigate -> {
                navController.navigate(action.destination, builder = action.builder)
            }

            is NavigatorAction.Replace -> {
                val destination = action.destination
                navController.navigate(destination) {
                    launchSingleTop = true
                    popUpTo(route = destination) {
                        inclusive = true
                    }
                }
            }

            null -> {}
        }
    }
}
