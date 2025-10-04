package tech.ermakov.notes.features.folders.ui

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import tech.ermakov.notes.core.navigation.Navigator
import tech.ermakov.notes.core.navigation.model.NavigatorAction
import tech.ermakov.notes.core.ui.viewModel.BaseViewModel
import tech.ermakov.notes.features.folders.ui.model.FoldersAction
import tech.ermakov.notes.features.folders.ui.model.FoldersUiState

internal class FoldersViewModel(
    private val navigator: Navigator,
) : BaseViewModel<FoldersUiState, FoldersAction>() {

    private val _state: MutableStateFlow<FoldersUiState> = MutableStateFlow(FoldersUiState())

    override val state: StateFlow<FoldersUiState>
        get() = _state.asStateFlow()

    override fun onAction(action: FoldersAction) {
        when (action) {
            FoldersAction.OnToolbarTitleClick -> navigateBack()

            FoldersAction.OnCreateNewFolderClick -> TODO()

            is FoldersAction.OnFolderClick -> TODO()
        }
    }

    private fun navigateBack() {
        navigator.onAction(NavigatorAction.Back())
    }
}
