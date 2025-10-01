package tech.ermakov.notes.features.notes.ui.noteEditor

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import tech.ermakov.notes.core.navigation.model.Destination

@Serializable
data class NoteEditorDestination(
    val noteId: Long,
    val folderId: Long,
) : Destination

fun NavGraphBuilder.noteEditorDestination() {
    composable<NoteEditorDestination> { navBackStackEntry ->
        val destination = navBackStackEntry.toRoute<NoteEditorDestination>()
        NoteEditorScreen(
            noteId = destination.noteId,
            folderId = destination.folderId,
        )
    }
}
