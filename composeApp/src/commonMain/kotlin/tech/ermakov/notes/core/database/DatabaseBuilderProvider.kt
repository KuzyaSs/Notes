package tech.ermakov.notes.core.database

import androidx.room.RoomDatabase

expect interface DatabaseBuilderProvider {

    fun provide(): RoomDatabase.Builder<NotesDatabase>
}
