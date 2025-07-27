package tech.ermakov.notes.features.notes

import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import tech.ermakov.notes.core.navigation.models.Destination

@Serializable
object NotesDestination : Destination

fun NavGraphBuilder.notesDestination() {
    composable<NotesDestination> {
        Text(text = "Notes")
    }
}
