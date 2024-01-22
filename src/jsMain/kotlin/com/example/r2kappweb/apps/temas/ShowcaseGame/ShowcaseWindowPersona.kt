package com.example.r2kappweb.apps.temas.ShowcaseGame
import io.kvision.core.AlignItems
import io.kvision.core.Display
import io.kvision.core.JustifyContent
import io.kvision.core.onEvent
import io.kvision.html.iframe
import io.kvision.panel.vPanel
import io.kvision.utils.px
import io.kvision.window.Window
class ShowcaseWindowPersona (caption: String?, init: (ShowcaseWindowPersona.() -> Unit)? = null) :
    Window(caption, 600.px, 600.px, closeButton = true) {
    init {
        init?.invoke(this)
        vPanel {
            margin = 10.px
            display = Display.FLEX
            justifyContent = JustifyContent.CENTER
            alignItems = AlignItems.CENTER
            iframe(src = "https://wordwall.net/es/embed/b897e4f1bb94432385308aed4305f37e?themeId=1&templateId=3&fontStackId=2") {
                iframeWidth = 600
                iframeHeight = 600
                maxWidth = 900.px
            }
        }
        onEvent {
            dragStartWindow = {
                self.getElement()?.style?.opacity = "0.5"
            }
            dragEndWindow = {
                self.getElement()?.style?.opacity = "1.0"
            }
        }
    }
}