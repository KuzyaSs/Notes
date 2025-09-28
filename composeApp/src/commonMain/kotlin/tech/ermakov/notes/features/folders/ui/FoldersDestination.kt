package tech.ermakov.notes.features.folders.ui

import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import tech.ermakov.notes.core.navigation.model.Destination

@Serializable
object FoldersDestination : Destination

fun NavGraphBuilder.foldersDestination() {
    composable<FoldersDestination> {
        Text(text = "FoldersDestination")
    }
}
