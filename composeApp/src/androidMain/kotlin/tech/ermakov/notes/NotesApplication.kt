package tech.ermakov.notes

import android.app.Application
import org.koin.android.ext.koin.androidContext
import tech.ermakov.notes.app.di.initDependencies

internal class NotesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initDependencies {
            androidContext(this@NotesApplication)
        }
    }
}
