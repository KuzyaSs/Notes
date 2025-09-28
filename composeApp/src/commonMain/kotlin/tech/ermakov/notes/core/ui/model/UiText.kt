package tech.ermakov.notes.core.ui.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Immutable
sealed interface UiText {

    class StringData(
        val value: String,
    ) : UiText

    class StringRes(
        val id: StringResource,
        val formatArgs: Array<Any> = emptyArray(),
    ) : UiText

    @Composable
    fun asString(): String {
        return when (this) {
            is StringData -> this.value
            is StringRes -> stringResource(resource = this.id, formatArgs = this.formatArgs)
        }
    }
}
