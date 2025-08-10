package tech.ermakov.notes.features.notes.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import tech.ermakov.notes.features.notes.data.local.dao.NoteDao
import tech.ermakov.notes.features.notes.data.local.model.NoteWithFolderName
import tech.ermakov.notes.features.notes.data.local.model.toNote
import tech.ermakov.notes.features.notes.data.local.model.toNoteEntity
import tech.ermakov.notes.features.notes.domain.model.NewNote
import tech.ermakov.notes.features.notes.domain.model.Note

internal class NoteRepositoryImpl(
    private val noteDao: NoteDao,
) : NoteRepository {

    override fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes().map { noteWithFolderNames ->
            noteWithFolderNames.map(NoteWithFolderName::toNote)
        }
    }

    override fun getNotesByFolderId(folderId: Int): Flow<List<Note>> {
        return noteDao.getNotesByFolderId(folderId = folderId).map { noteWithFolderNames ->
            noteWithFolderNames.map(NoteWithFolderName::toNote)
        }
    }

    override fun getTrashedNotes(): Flow<List<Note>> {
        return noteDao.getTrashedNotes().map { noteWithFolderNames ->
            noteWithFolderNames.map(NoteWithFolderName::toNote)
        }
    }

    override suspend fun insertNote(newNote: NewNote): Long {
        return noteDao.insertNote(
            noteEntity = newNote.toNoteEntity(),
        )
    }
}
