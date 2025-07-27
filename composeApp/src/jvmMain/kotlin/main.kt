import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import java.awt.Dimension
import tech.ermakov.notes.app.App
import tech.ermakov.notes.app.di.initDependencies

fun main() {
    initDependencies()
    application {
        Window(
            title = "Notes",
            state = rememberWindowState(width = 800.dp, height = 600.dp),
            onCloseRequest = ::exitApplication,
        ) {
            window.minimumSize = Dimension(350, 600)
            App()
        }
    }
}
