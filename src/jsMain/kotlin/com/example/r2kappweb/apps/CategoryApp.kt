package com.example.r2kappweb.apps

import com.example.r2kappweb.apps.temas.*
import io.kvision.core.*
import io.kvision.html.div
import io.kvision.html.image
import io.kvision.html.link
import io.kvision.panel.FieldsetPanel
import io.kvision.panel.FlexPanel
import io.kvision.panel.fieldsetPanel
import io.kvision.panel.flexPanel
import io.kvision.utils.perc
import io.kvision.utils.px

class CategoryApp : DesktopWindow("Temario", "fa-solid fa-book-open", 900, 400) {
    private var contentPanel: FlexPanel
    init {
        //toggleMaximize() Para que inicie maximizado
        isResizable = true
        maximizeButton = true
        minimizeButton = true
        minWidth = 400.px
        minHeight = 150.px
        padding = 2.px
        height = 680.px

        val cardFlexPanel = flexPanel(FlexDirection.ROW, FlexWrap.WRAP, alignContent = AlignContent.STRETCH, alignItems = AlignItems.STRETCH) {
            justifyContent = JustifyContent.CENTER
            for (i in cards) {
                add(createCard(i))
            }
        }
        contentPanel = cardFlexPanel
    }
    //Indice de id
    private fun mostrarContenidoTema(idTema: String) {
        contentPanel.removeAll()
        when(idTema) {
            "persona" -> contentPanel.add(PersonaPage(this::mostrarTarjetas))
            "familia" -> contentPanel.add(FamiliaPage(this::mostrarTarjetas))
            "sociedad" -> contentPanel.add(SociedadPage(this::mostrarTarjetas))
            "democracia" -> contentPanel.add(DemocraciaPage(this::mostrarTarjetas))
            "constitucion" -> contentPanel.add(ConstitucionPage(this::mostrarTarjetas))
            "estado" -> contentPanel.add(EstadoPage(this::mostrarTarjetas))
            "legislativo" -> contentPanel.add(LegislativoPage(this::mostrarTarjetas))
        }
    }
    private fun mostrarTarjetas() {
        contentPanel.removeAll()
        contentPanel.add(createPanel())
    }
    //Panel de Cards
    private fun createPanel(): FlexPanel {
        return flexPanel(FlexDirection.ROW, FlexWrap.WRAP, alignContent = AlignContent.STRETCH, alignItems = AlignItems.STRETCH) {
            justifyContent = JustifyContent.CENTER
            for (carta in cards) {
                add(createCard(carta))
            }
        }
    }
    //Cards
    private fun createCard(carta: Tema): FieldsetPanel {
        return fieldsetPanel(carta.nombre) {
            paddingTop = 10.px
            paddingBottom = 10.px
            margin = 10.px
            div(carta.subtitulo){ addCssClass("card-subtitle")}
            image(src = carta.rutaBanner, alt = carta.nombre).apply {
                width = 100.perc
                maxHeight = 350.px
                maxWidth = 600.px
            }
            div(carta.descripcion) { addCssClass("card-text")}.apply {
                maxWidth = 600.px
            }
            link("Ir a...", "#").onClick {
                //Si se realiza llama a .removeAll y borra el contenido
                //(this@CategoryApp).mostrarContenidoTema(carta.id)
                mostrarContenidoTema(carta.id)
            }
        }
    }

    companion object {
        fun run(container: Container) {
            container.add(CategoryApp())
        }
    }
}