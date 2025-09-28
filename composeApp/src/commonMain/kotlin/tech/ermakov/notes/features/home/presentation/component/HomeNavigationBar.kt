package tech.ermakov.notes.features.home.presentation.component

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import tech.ermakov.notes.core.navigation.ComposeNavigator
import tech.ermakov.notes.core.navigation.Navigator
import tech.ermakov.notes.core.navigation.model.NavigatorAction
import tech.ermakov.notes.core.ui.theme.NotesTheme
import tech.ermakov.notes.features.home.presentation.model.HomeNavigationBarItem

@Composable
internal fun HomeNavigationBar(
    homeNavigator: Navigator,
    navController: NavHostController,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = NotesTheme.colors.backgroundPrimary,
    ) {
        HomeNavigationBarItem.entries.forEach { item ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { destination ->
                    destination.hasRoute(item.destination::class)
                } == true,
                onClick = {
                    homeNavigator.onAction(
                        NavigatorAction.Navigate(destination = item.destination) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        },
                    )
                },
                icon = {
                    Icon(
                        painter = painterResource(resource = item.icon),
                        contentDescription = stringResource(resource = item.label),
                    )
                },
                label = {
                    Text(text = stringResource(resource = item.label))
                },
                colors = NavigationBarItemDefaults.colors().copy(
                    selectedTextColor = NotesTheme.colors.accent,
                    selectedIconColor = NotesTheme.colors.accent,
                    selectedIndicatorColor = NotesTheme.colors.transparent,
                    unselectedTextColor = NotesTheme.colors.textSecondary,
                    unselectedIconColor = NotesTheme.colors.textSecondary,
                )
            )
        }
    }
}

@Preview
@Composable
private fun HomeNavigationBarPreview() {
    NotesTheme {
        HomeNavigationBar(
            navController = rememberNavController(),
            homeNavigator = ComposeNavigator(),
        )
    }
}
