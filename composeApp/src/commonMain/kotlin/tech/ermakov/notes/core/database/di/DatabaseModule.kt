package tech.ermakov.notes.core.database.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.module.Module
import org.koin.dsl.module
import tech.ermakov.notes.core.database.DatabaseBuilderProvider
import tech.ermakov.notes.core.database.NotesDatabase

expect val databaseBuilderModule: Module

val databaseModule = module {
    includes(databaseBuilderModule)
    single<NotesDatabase> {
        get<DatabaseBuilderProvider>().provide()
            .setDriver(driver = BundledSQLiteDriver())
            .setQueryCoroutineContext(context = Dispatchers.IO)
            .build()
    }
}
