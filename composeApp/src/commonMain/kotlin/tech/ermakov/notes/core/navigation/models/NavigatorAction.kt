package tech.ermakov.notes.core.navigation.models

sealed interface NavigatorAction {

    class Back() : NavigatorAction {

        override fun equals(other: Any?): Boolean {
            return this === other
        }

        override fun hashCode(): Int {
            return this::class.hashCode()
        }
    }

    class Navigate(val destination: Destination) : NavigatorAction

    class Replace(val destination: Destination) : NavigatorAction
}
