package com.example.r2kappweb.screens

import com.example.r2kappweb.apps.*
import io.kvision.core.*
import io.kvision.dropdown.ddLink
import io.kvision.dropdown.dropDown
import io.kvision.dropdown.separator
import io.kvision.html.Image
import io.kvision.html.Link
import io.kvision.modal.Alert
import io.kvision.navbar.Nav
import io.kvision.navbar.NavbarType
import io.kvision.navbar.nav
import io.kvision.navbar.navbar
import io.kvision.panel.Root
import io.kvision.panel.SimplePanel
import io.kvision.panel.flexPanel
import io.kvision.utils.perc
import io.kvision.utils.px
import io.kvision.utils.vh

class HomeScreen(private val root: Root, private val onLogout: () -> Unit) : SimplePanel() {
    init {
        this.apply {
            style {
                width = 100.perc
                height = 100.vh
                display = Display.FLEX
                flexDirection = FlexDirection.COLUMN
                justifyContent = JustifyContent.FLEXSTART
                alignItems = AlignItems.FLEXSTART
            }
        }
        navbar(type = NavbarType.FIXEDTOP) {
            nav {
                dropDown("Menu", icon = "fab fa-windows", forNavbar = true, arrowVisible = false) {
                    ddLink("Calculadora", "#", icon = "fas fa-calculator").onClick {
                        Calculator.run(root)
                    }
                    ddLink("Editor de Texto", "#", icon = "fas fa-edit").onClick {
                        TextEditor.run(root)
                    }
                    ddLink("Paint", "#", icon = "fas fa-paint-brush").onClick {
                        Paint.run(root)
                    }
                    ddLink("Web Browser", "#", icon = "fab fa-firefox").onClick {
                        WebBrowser.run(root)
                    }
                    ddLink("R2K App", "#", icon = "fa-solid fa-book-open").onClick {
                        CategoryApp.run(root)
                    }
                    separator()
                    ddLink("Sobre la App", "#", icon = "fas fa-info-circle").onClick {
                        Alert.show("Right to Know, la App", "Esta es una aplicación con fines educativos.")
                    }
                    ddLink("LogOut", "#", icon = "fas fa-power-off").onClick {
                        onLogout()
                    }
                }
            }
            taskBar = nav()
        }

        flexPanel(
            FlexDirection.COLUMN,
            FlexWrap.WRAP,
            spacing = 20
        ) {
            marginTop = 70.px
            padding = 30.px
            add(DesktopIcon("fas fa-calculator", "Calculadora").apply {
                onEvent {
                    dblclick = {
                        Calculator.run(root)
                    }
                    touchstart = {
                        Calculator.run(root)
                    }
                }
            })
            add(DesktopIcon("fas fa-edit", "Editor de Texto").apply {
                onEvent {
                    dblclick = {
                        TextEditor.run(root)
                    }
                    touchstart = {
                        TextEditor.run(root)
                    }
                }
            })
            add(DesktopIcon("fas fa-paint-brush", "Paint").apply {
                onEvent {
                    dblclick = {
                        Paint.run(root)
                    }
                    touchstart = {
                        Paint.run(root)
                    }
                }
            })
            add(DesktopIcon("fab fa-firefox", "Web Browser").apply {
                onEvent {
                    dblclick = {
                        WebBrowser.run(root)
                    }
                    touchstart = {
                        WebBrowser.run(root)
                    }
                }
            })
            add(DesktopIcon("fa-solid fa-book-open", "R2K App").apply {
                onEvent {
                    dblclick = {
                        CategoryApp.run(root)
                    }
                    touchstart = {
                        CategoryApp.run(root)
                    }
                }
            })
        }
    }
    companion object {

        lateinit var taskBar: Nav

        fun addTask(window: DesktopWindow): Component {
            val task =
                Link(window.caption ?: "Window", icon = window.icon, className = "nav-item nav-link") {
                    border = Border(1.px, BorderStyle.SOLID)
                    marginLeft = 5.px
                    onClick {
                        if (window.minimized) window.toggleMinimize()
                        window.toFront()
                        window.focus()
                    }
                }
            taskBar.add(task)
            return task
        }
        fun removeTask(task: Component) {
            taskBar.remove(task)
            task.dispose()
        }
    }

}