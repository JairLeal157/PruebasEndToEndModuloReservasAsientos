package co.com.udea.test.modulogestionasientos.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.udea.test.modulogestionasientos.userinterfaces.PaginaReservas.ESTADO_ASIENTO_OCUPADO;

public class ValidationVerAsientoOcupado implements Question<Boolean> {
    public ValidationVerAsientoOcupado(){}
    @Override
    public Boolean answeredBy(Actor actor) {
        return ESTADO_ASIENTO_OCUPADO.resolveFor(actor).isVisible();
    }

    public static ValidationVerAsientoOcupado seOberservaAsientoOcupado(){
        return new ValidationVerAsientoOcupado();
    }
}
