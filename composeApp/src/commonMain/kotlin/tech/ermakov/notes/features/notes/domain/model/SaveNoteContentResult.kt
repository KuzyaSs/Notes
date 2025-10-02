package tech.ermakov.notes.features.notes.domain.model

import tech.ermakov.notes.features.notes.domain.useCase.SaveNoteContentUseCase

/**
 * An interface used as a result after saving of the note content.
 *
 * @see SaveNoteContentUseCase
 */
sealed interface SaveNoteContentResult {

    /**
     * The new note is created.
     *
     * @property noteId the id of the created note.
     */
    data class Created(val noteId: Long) : SaveNoteContentResult

    /**
     * The existence note is updated.
     *
     * @property noteId the id of the updated note.
     */
    data class Updated(val noteId: Long) : SaveNoteContentResult

    /**
     * The existence note is deleted.
     */
    data object DeletedPermanently : SaveNoteContentResult

    /**
     * Nothing happened (e.g., existence note isn't changed).
     */
    data object Nothing : SaveNoteContentResult
}
