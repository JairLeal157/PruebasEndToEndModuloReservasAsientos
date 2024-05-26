package co.com.udea.test.modulogestionasientos.questions;

import co.com.udea.test.modulogestionasientos.userinterfaces.PaginaReservas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

import java.util.List;

public class ValidationVerPreciosDeAsientosPasajeros implements Question<Boolean> {
    public ValidationVerPreciosDeAsientosPasajeros(){}
    @Override
    public Boolean answeredBy(Actor actor) {
        List<String> pasajeros = TextContent.ofEach(PaginaReservas.LISTA_PASAJEROS).answeredBy(actor).stream().toList();
        for (String pasajero : pasajeros) {
            boolean precio = pasajero.contains("$");
            if (!precio) {
                return false;
            }
        }
        return true;
    }

    public static ValidationVerPreciosDeAsientosPasajeros seObservaLosPreciosDeLosAsientos(){
        return new ValidationVerPreciosDeAsientosPasajeros();
    }
}
