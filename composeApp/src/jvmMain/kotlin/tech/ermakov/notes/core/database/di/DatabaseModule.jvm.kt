package tech.ermakov.notes.core.database.di

import org.koin.core.module.Module
import org.koin.dsl.module
import tech.ermakov.notes.core.database.DatabaseBuilderProvider
import tech.ermakov.notes.core.database.DatabaseBuilderProviderImpl

actual val databaseBuilderModule: Module = module {
    single<DatabaseBuilderProvider> {
        DatabaseBuilderProviderImpl()
    }
}
