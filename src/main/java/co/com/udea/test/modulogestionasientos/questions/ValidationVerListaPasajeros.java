package co.com.udea.test.modulogestionasientos.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.udea.test.modulogestionasientos.userinterfaces.PaginaReservas.LISTA_PASAJEROS;

public class ValidationVerListaPasajeros implements Question<Boolean> {
    public ValidationVerListaPasajeros(){}
    @Override
    public Boolean answeredBy(Actor actor) {
        return LISTA_PASAJEROS.resolveFor(actor).isPresent();
    }

    public static ValidationVerListaPasajeros ExisteListaPasajeros(){
        return new ValidationVerListaPasajeros();
    }
}
