package tech.ermakov.notes.features.folders.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import tech.ermakov.notes.core.database.NotesDatabase
import tech.ermakov.notes.features.folders.data.local.dao.FolderDao
import tech.ermakov.notes.features.folders.data.repository.FolderRepository
import tech.ermakov.notes.features.folders.data.repository.FolderRepositoryImpl
import tech.ermakov.notes.features.folders.ui.FoldersViewModel

val foldersModule = module {

    viewModel<FoldersViewModel> {
        FoldersViewModel(
            navigator = get(),
        )
    }

    single<FolderRepository> {
        FolderRepositoryImpl(
            folderDao = get(),
        )
    }

    single<FolderDao> {
        get<NotesDatabase>().getFolderDao()
    }
}
