package co.com.udea.test.modulogestionasientos.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.udea.test.modulogestionasientos.userinterfaces.PaginaReservas.AVISO_CONFIRMACION;

public class ValidationVerConfirmacionAsiento implements Question<Boolean> {
    public ValidationVerConfirmacionAsiento(){}
    @Override
    public Boolean answeredBy(Actor actor) {
        return AVISO_CONFIRMACION.resolveFor(actor).isPresent();
    }

    public static ValidationVerConfirmacionAsiento estaPresente(){
        return new ValidationVerConfirmacionAsiento();
    }
}
