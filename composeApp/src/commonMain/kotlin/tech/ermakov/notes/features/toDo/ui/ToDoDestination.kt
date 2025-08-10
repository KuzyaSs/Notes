package tech.ermakov.notes.features.toDo.ui

import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import tech.ermakov.notes.core.navigation.model.Destination

@Serializable
object ToDoDestination : Destination

fun NavGraphBuilder.toDoDestination() {
    composable<ToDoDestination> {
        Text(text = "To-do")
    }
}
