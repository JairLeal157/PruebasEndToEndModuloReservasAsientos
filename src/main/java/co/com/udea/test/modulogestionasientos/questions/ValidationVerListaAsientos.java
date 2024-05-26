package co.com.udea.test.modulogestionasientos.questions;

import co.com.udea.test.modulogestionasientos.userinterfaces.PaginaReservas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidationVerListaAsientos implements Question<Boolean> {
    public ValidationVerListaAsientos(){}
    @Override
    public Boolean answeredBy(Actor actor) {
        return PaginaReservas.LISTA_ASIENTOS.resolveFor(actor).isPresent();
    }

    public static ValidationVerListaAsientos seObservanAsientos(){
        return new ValidationVerListaAsientos();
    }
}
