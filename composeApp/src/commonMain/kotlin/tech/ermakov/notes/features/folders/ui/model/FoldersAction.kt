package tech.ermakov.notes.features.folders.ui.model

internal sealed interface FoldersAction {

    data object OnToolbarTitleClick : FoldersAction

    data object OnCreateNewFolderClick : FoldersAction

    data class OnFolderClick(val folderId: Long) : FoldersAction
}
