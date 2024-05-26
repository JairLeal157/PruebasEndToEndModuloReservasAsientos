package co.com.udea.test.modulogestionasientos.questions;

import co.com.udea.test.modulogestionasientos.userinterfaces.PaginaReservas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

import java.util.List;

public class ValidationBotonSeleccionar implements Question<Boolean> {
    public ValidationBotonSeleccionar(String sinAsientoAsignado) {
        this.sinAsientoAsignado = sinAsientoAsignado;
    }
    private String sinAsientoAsignado;
    @Override
    public Boolean answeredBy(Actor actor) {
        List<String> pasajeros = TextContent.ofEach(PaginaReservas.LISTA_PASAJEROS).answeredBy(actor).stream().toList();
        for (String pasajero : pasajeros) {
            boolean naPresente = pasajero.contains("N/A");
            if (naPresente) {
                boolean botonSeleccionarPresente = pasajero.contains("Seleccionar");
                if (!botonSeleccionarPresente) {
                    return false;
                }
            }
        }
        return true;
    }

    public static ValidationBotonSeleccionar existeSiNoHayAsientoAsignado(String sinAsientoAsignado){
        return new ValidationBotonSeleccionar(sinAsientoAsignado);
    }
}
