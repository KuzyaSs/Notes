package tech.ermakov.notes.core.ui.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<STATE, ACTION> : ViewModel() {

    abstract val state: StateFlow<STATE>

    abstract fun onAction(action: ACTION)
}
