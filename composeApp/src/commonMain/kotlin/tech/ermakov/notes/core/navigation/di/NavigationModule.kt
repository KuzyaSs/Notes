package tech.ermakov.notes.core.navigation.di

import org.koin.dsl.module
import tech.ermakov.notes.core.navigation.ComposeNavigator
import tech.ermakov.notes.core.navigation.Navigator

val navigationModule = module {
    single<Navigator> { ComposeNavigator() }
}
