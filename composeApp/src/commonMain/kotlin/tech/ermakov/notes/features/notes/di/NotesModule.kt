package tech.ermakov.notes.features.notes.di

import org.koin.dsl.module
import tech.ermakov.notes.core.database.NotesDatabase
import tech.ermakov.notes.features.notes.data.local.dao.NoteDao
import tech.ermakov.notes.features.notes.data.repository.NoteRepository
import tech.ermakov.notes.features.notes.data.repository.NoteRepositoryImpl

val notesModule = module {
    single<NoteRepository> {
        NoteRepositoryImpl(
            noteDao = get(),
        )
    }

    single<NoteDao> {
        get<NotesDatabase>().getNoteDao()
    }
}
