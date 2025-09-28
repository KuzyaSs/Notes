package tech.ermakov.notes.features.settings.ui

import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import tech.ermakov.notes.core.navigation.model.Destination

@Serializable
object SettingsDestination : Destination

fun NavGraphBuilder.settingsDestination() {
    composable<SettingsDestination> {
        Text(text = "SettingsDestination")
    }
}
