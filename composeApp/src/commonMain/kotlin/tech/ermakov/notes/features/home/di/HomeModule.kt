package tech.ermakov.notes.features.home.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import tech.ermakov.notes.core.navigation.ComposeNavigator
import tech.ermakov.notes.core.navigation.Navigator

internal val homeNavigatorQualifier = named("home_navigator")

val homeModule = module {
    single<Navigator>(qualifier = homeNavigatorQualifier) { ComposeNavigator() }
}
