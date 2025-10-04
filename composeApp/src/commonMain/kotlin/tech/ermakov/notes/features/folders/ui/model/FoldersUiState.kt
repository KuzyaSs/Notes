package tech.ermakov.notes.features.folders.ui.model

import androidx.compose.runtime.Immutable

@Immutable
internal data class FoldersUiState(
    val folders: List<UiFolder> = emptyList(),
    val isLoading: Boolean = true,
)
