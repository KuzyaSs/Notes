package tech.ermakov.notes.features.notes.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import tech.ermakov.notes.core.database.NotesDatabase
import tech.ermakov.notes.features.notes.data.local.dao.NoteDao
import tech.ermakov.notes.features.notes.data.repository.NoteRepository
import tech.ermakov.notes.features.notes.data.repository.NoteRepositoryImpl
import tech.ermakov.notes.features.notes.domain.useCase.GetNoteByIdUseCase
import tech.ermakov.notes.features.notes.domain.useCase.GetNotesUseCase
import tech.ermakov.notes.features.notes.domain.useCase.MoveNoteByIdUseCase
import tech.ermakov.notes.features.notes.domain.useCase.SaveNoteContentUseCase
import tech.ermakov.notes.features.notes.ui.noteEditor.NoteEditorViewModel
import tech.ermakov.notes.features.notes.ui.notes.NotesViewModel

val notesModule = module {
    viewModel<NotesViewModel> {
        NotesViewModel(
            getNotesUseCase = get(),
            navigator = get(),
        )
    }

    viewModel<NoteEditorViewModel> { params ->
        NoteEditorViewModel(
            noteId = params[0],
            folderId = params[1],
            getNoteByIdUseCase = get(),
            saveNoteContentUseCase = get(),
            moveNoteByIdUseCase = get(),
            noteRepository = get(),
            navigator = get(),
        )
    }

    single<GetNotesUseCase> {
        GetNotesUseCase(
            notesRepository = get(),
        )
    }

    single<GetNoteByIdUseCase> {
        GetNoteByIdUseCase(
            notesRepository = get(),
        )
    }

    single<SaveNoteContentUseCase> {
        SaveNoteContentUseCase(
            notesRepository = get(),
        )
    }

    single<MoveNoteByIdUseCase> {
        MoveNoteByIdUseCase(
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
