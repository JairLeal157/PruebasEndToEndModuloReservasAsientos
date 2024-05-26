package co.com.udea.test.modulogestionasientos.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaReservas extends PageObject {

    public static final Target LISTA_PASAJEROS = Target.the("lista de pasajeros").locatedBy("/html/body/main/div/section/section[1]");

    public static final Target AVISO_CONFIRMACION = Target.the("aviso de confirmación")
            .locatedBy("//div[contains(text(), 'confirmado')]");

    public static final Target BOTON_SELECCIONAR = Target.the("botón Seleccionar")
            .locatedByFirstMatching(".//button[contains(text(), 'Seleccionar')]")
            .inside(LISTA_PASAJEROS);

    public static final Target PRECIO_ADICIONAL = Target.the("precio adicional")
            .locatedBy("/html/body/main/div/div/div");
    public static final Target LISTA_ASIENTOS = Target.the("lista de asientos").locatedBy("/html/body/main/div/section/section[1]/div/section");

    public static final Target BOTON_SELECCIONAR_ASIENTO = Target.the("botón Seleccionar Asiento")
            .locatedByFirstMatching(".//button[contains(text(), 'Seleccionar')]")
            .inside(LISTA_ASIENTOS);

    public static final Target ASIENTOS_DE_LA_LISTA_DE_ASIENTOS =Target.the("clase de asiento")
            .locatedBy(".//div[contains(text(), 'Turista') or contains(text(), 'Primera Clase') or contains(text(), 'Ejecutivo')]")
            .inside(LISTA_ASIENTOS);

    public static final Target DISPONIBILIDAD_ASIENTOS = Target.the("disponibilidad de asientos")
            .locatedBy(".//div[contains(text(), 'Disponibilidad')]")
            .inside(LISTA_ASIENTOS);

    public static final Target SILLA = Target.the("silla")
            .locatedBy(".//div[contains(text(), 'Silla')]")
            .inside(LISTA_ASIENTOS);
    //Ubicación, Clase y Valor
    public static final Target UBICACION = Target.the("ubicación")
            .locatedBy(".//div[contains(text(), 'Ubicación')]")
            .inside(LISTA_ASIENTOS);

    public static final Target CLASE = Target.the("clase")
            .locatedBy(".//div[contains(text(), 'Clase')]")
            .inside(LISTA_ASIENTOS);

    public static final Target VALOR = Target.the("valor")
            .locatedBy(".//div[contains(text(), 'Valor')]")
            .inside(LISTA_ASIENTOS);

    public static final Target ASIENTO = Target.the("asiento")
            .locatedBy(".//div[contains(text(), 'Turista')]")
            .inside(LISTA_ASIENTOS);

    public static final Target ESTADO_ASIENTO_OCUPADO = Target.the("estado del asiento ocupado")
            .locatedBy(".//svg[contains(@class, 'icon-tabler-armchair-2-off')]");

}
