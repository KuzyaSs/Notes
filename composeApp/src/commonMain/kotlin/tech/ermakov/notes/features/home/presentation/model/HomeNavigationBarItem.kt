package tech.ermakov.notes.features.home.presentation.model

import notes.composeapp.generated.resources.Res
import notes.composeapp.generated.resources.ic_notes
import notes.composeapp.generated.resources.ic_to_do
import notes.composeapp.generated.resources.notes
import notes.composeapp.generated.resources.to_do
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import tech.ermakov.notes.core.navigation.model.Destination
import tech.ermakov.notes.features.notes.ui.notes.NotesDestination
import tech.ermakov.notes.features.toDo.ui.ToDoDestination

internal enum class HomeNavigationBarItem(
    val destination: Destination,
    val label: StringResource,
    val icon: DrawableResource,
) {

    Notes(
        destination = NotesDestination,
        label = Res.string.notes,
        icon = Res.drawable.ic_notes,
    ),
    ToDo(
        destination = ToDoDestination,
        label = Res.string.to_do,
        icon = Res.drawable.ic_to_do,
    ),
}
