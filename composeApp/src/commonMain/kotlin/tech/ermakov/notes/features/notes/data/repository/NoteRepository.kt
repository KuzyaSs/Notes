package tech.ermakov.notes.features.notes.data.repository

import kotlinx.coroutines.flow.Flow
import tech.ermakov.notes.features.notes.domain.model.NewNote
import tech.ermakov.notes.features.notes.domain.model.Note

interface NoteRepository {

    fun getAllNotes(): Flow<List<Note>>

    fun getNotesByFolderId(folderId: Int): Flow<List<Note>>

    fun getTrashedNotes(): Flow<List<Note>>

    suspend fun insertNote(newNote: NewNote): Long
}
