package tech.ermakov.notes.features.notes.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import tech.ermakov.notes.features.notes.data.local.dao.NoteDao
import tech.ermakov.notes.features.notes.data.local.model.NoteWithFolderName
import tech.ermakov.notes.features.notes.data.local.model.toNote
import tech.ermakov.notes.features.notes.data.local.model.toNoteEntity
import tech.ermakov.notes.features.notes.domain.model.Note
import kotlin.collections.map

internal class NoteRepositoryImpl(
    private val noteDao: NoteDao,
) : NoteRepository {

    override fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes().map { notesWithFolderName ->
            notesWithFolderName.map(NoteWithFolderName::toNote)
        }
    }

    override fun getNotesByFolderId(folderId: Long): Flow<List<Note>> {
        return noteDao.getNotesByFolderId(folderId = folderId).map { notesWithFolderName ->
            notesWithFolderName.map(NoteWithFolderName::toNote)
        }
    }

    override fun getTrashedNotes(): Flow<List<Note>> {
        return noteDao.getTrashedNotes().map { noteWithFolderNames ->
            noteWithFolderNames.map(NoteWithFolderName::toNote)
        }
    }

    override fun getNoteById(noteId: Long): Flow<Note?> {
        return noteDao.getNoteById(noteId = noteId).map { noteWithFolderName ->
            noteWithFolderName?.toNote()
        }
    }

    override suspend fun upsertNote(note: Note): Long {
        return noteDao.upsertNote(
            noteEntity = note.toNoteEntity(),
        )
    }

    override suspend fun deleteNoteById(noteId: Long): Int {
        return noteDao.deleteNoteById(noteId = noteId)
    }
}
