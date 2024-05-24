package co.com.udea.certificacion.autenticacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.udea.certificacion.autenticacion.userinterfaces.PaginaReservas.LISTA_ASIENTOS;
import static co.com.udea.certificacion.autenticacion.userinterfaces.PaginaReservas.LISTA_PASAJEROS;

public class ValidationVerListaAsientos implements Question<Boolean> {
    public ValidationVerListaAsientos(){}
    @Override
    public Boolean answeredBy(Actor actor) {
        return LISTA_ASIENTOS.resolveFor(actor).isPresent();
    }

    public static ValidationVerListaAsientos seObservanAsientos(){
        return new ValidationVerListaAsientos();
    }
}
