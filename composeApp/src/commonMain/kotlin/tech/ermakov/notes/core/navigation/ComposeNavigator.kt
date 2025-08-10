package tech.ermakov.notes.core.navigation

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import tech.ermakov.notes.core.navigation.model.NavigatorAction

internal class ComposeNavigator(
    dispatcher: CoroutineDispatcher = Dispatchers.Main.immediate,
) : Navigator {

    private val _action: MutableSharedFlow<NavigatorAction?> = MutableSharedFlow()

    override val action: SharedFlow<NavigatorAction?>
        get() = _action.asSharedFlow()

    private val scope by lazy {
        CoroutineScope(dispatcher + SupervisorJob())
    }

    override fun onAction(action: NavigatorAction) {
        scope.launch {
            _action.emit(action)
        }
    }
}
