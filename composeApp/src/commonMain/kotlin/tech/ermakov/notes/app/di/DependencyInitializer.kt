package tech.ermakov.notes.app.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import tech.ermakov.notes.core.database.di.databaseModule
import tech.ermakov.notes.core.navigation.di.navigationModule
import tech.ermakov.notes.features.folders.di.foldersModule
import tech.ermakov.notes.features.home.di.homeModule
import tech.ermakov.notes.features.notes.di.notesModule

fun initDependencies(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            // Core.
            navigationModule,
            databaseModule,
            // Features.
            homeModule,
            notesModule,
            foldersModule,
        )
    }
}
