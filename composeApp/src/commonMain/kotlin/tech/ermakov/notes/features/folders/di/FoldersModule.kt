package tech.ermakov.notes.features.folders.di

import org.koin.dsl.module
import tech.ermakov.notes.core.database.NotesDatabase
import tech.ermakov.notes.features.folders.data.local.dao.FolderDao
import tech.ermakov.notes.features.folders.data.repository.FolderRepository
import tech.ermakov.notes.features.folders.data.repository.FolderRepositoryImpl

val foldersModule = module {
    single<FolderRepository> {
        FolderRepositoryImpl(
            folderDao = get(),
        )
    }

    single<FolderDao> {
        get<NotesDatabase>().getFolderDao()
    }
}
