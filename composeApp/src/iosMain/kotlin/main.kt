import androidx.compose.ui.window.ComposeUIViewController
import tech.ermakov.notes.app.App
import platform.UIKit.UIViewController
import tech.ermakov.notes.app.di.initDependencies

fun MainViewController(): UIViewController = ComposeUIViewController(
    configure = {
        initDependencies()
    },
) {
    App()
}
