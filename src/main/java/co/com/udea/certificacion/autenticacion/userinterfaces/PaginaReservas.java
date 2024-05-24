package co.com.udea.certificacion.autenticacion.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaReservas extends PageObject {

    public static final Target LISTA_PASAJEROS = Target.the("lista de pasajeros").locatedBy("/html/body/main/div/section/section[1]");

    public static final Target BOTON_SELECCIONAR = Target.the("botón Seleccionar")
            .locatedByFirstMatching(".//button[contains(text(), 'Seleccionar')]")
            .inside(LISTA_PASAJEROS);

    public static final Target LISTA_ASIENTOS = Target.the("lista de asientos").locatedBy("/html/body/main/div/section/section[1]/div/section");
}
