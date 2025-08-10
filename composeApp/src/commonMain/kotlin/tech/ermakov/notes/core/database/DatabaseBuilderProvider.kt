package tech.ermakov.notes.core.database

import androidx.room.RoomDatabase

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect interface DatabaseBuilderProvider {

    fun provide(): RoomDatabase.Builder<NotesDatabase>
}
