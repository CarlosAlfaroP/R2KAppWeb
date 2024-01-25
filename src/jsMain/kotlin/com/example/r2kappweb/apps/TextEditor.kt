package com.example.r2kappweb.apps

import io.kvision.core.Container
import io.kvision.core.CssSize
import io.kvision.core.UNIT
import io.kvision.form.text.RichTextInput
import io.kvision.snabbdom.VNode
import io.kvision.utils.px
import kotlinx.browser.document

class TextEditor : DesktopWindow("Editor de texto", "fas fa-edit", 700, 400) {

    override var height: CssSize?
        get() = super.height
        set(value) {
            super.height = value
            if (value?.second == UNIT.px) {
                richText.height = (value.first.toInt() - 93).px
            }
        }

    val richText = object : RichTextInput() {
        override fun afterInsert(node: VNode) {
            super.afterInsert(node)
            // Eliminar el botón de adjuntar archivos después de que el editor se haya inicializado
            this.getElement()?.addEventListener("trix-initialize", { _ ->
                val toolbarElement = document.querySelector("trix-toolbar")
                val attachFilesButton = toolbarElement?.querySelector("[data-trix-action=\"attachFiles\"]")
                attachFilesButton?.parentNode?.removeChild(attachFilesButton)
            })
        }
    }

    init {
        minWidth = 500.px
        minHeight = 180.px
        padding = 3.px
        richText.height = 370.px
        add(richText)
        height = 457.px
    }

    override fun focus() {
        super.focus()
        richText.focus()
    }

    companion object {
        fun run(container: Container) {
            container.add(TextEditor())
        }
    }
}