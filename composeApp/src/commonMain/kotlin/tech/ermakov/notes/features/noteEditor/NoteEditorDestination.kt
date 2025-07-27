package tech.ermakov.notes.features.noteEditor

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import tech.ermakov.notes.core.navigation.models.Destination

@Serializable
object NoteEditorDestination : Destination

fun NavGraphBuilder.noteEditorDestination() {
    composable<NoteEditorDestination> {

    }
}
