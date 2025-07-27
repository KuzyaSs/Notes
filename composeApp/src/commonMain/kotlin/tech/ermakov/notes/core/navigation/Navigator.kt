package tech.ermakov.notes.core.navigation

import kotlinx.coroutines.flow.SharedFlow
import tech.ermakov.notes.core.navigation.models.NavigatorAction

interface Navigator {

    val action: SharedFlow<NavigatorAction?>

    fun onAction(action: NavigatorAction)
}
