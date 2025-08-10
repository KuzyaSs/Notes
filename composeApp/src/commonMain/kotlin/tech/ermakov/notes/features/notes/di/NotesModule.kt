package tech.ermakov.notes.features.notes.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import tech.ermakov.notes.core.database.NotesDatabase
import tech.ermakov.notes.features.notes.data.local.dao.NoteDao
import tech.ermakov.notes.features.notes.data.repository.NoteRepository
import tech.ermakov.notes.features.notes.data.repository.NoteRepositoryImpl
import tech.ermakov.notes.features.notes.domain.useCase.GetNotesUseCase
import tech.ermakov.notes.features.notes.ui.NotesViewModel

val notesModule = module {
    viewModel<NotesViewModel> {
        NotesViewModel(
            getNotesUseCase = get(),
            navigator = get(),
        )
    }

    single<GetNotesUseCase> {
        GetNotesUseCase(
            notesRepository = get(),
        )
    }

    single<NoteRepository> {
        NoteRepositoryImpl(
            noteDao = get(),
        )
    }

    single<NoteDao> {
        get<NotesDatabase>().getNoteDao()
    }
}
