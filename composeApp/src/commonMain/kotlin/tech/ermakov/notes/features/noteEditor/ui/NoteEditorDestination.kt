package tech.ermakov.notes.features.noteEditor.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import tech.ermakov.notes.core.navigation.model.Destination

@Serializable
object NoteEditorDestination : Destination

fun NavGraphBuilder.noteEditorDestination() {
    composable<NoteEditorDestination> {

    }
}
