package tech.ermakov.notes.app.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import tech.ermakov.notes.core.navigation.di.navigationModule
import tech.ermakov.notes.features.home.di.homeModule

fun initDependencies(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            navigationModule,
            homeModule,
        )
    }
}
