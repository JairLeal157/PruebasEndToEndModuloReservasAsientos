package co.com.udea.test.modulogestionasientos.questions;

import co.com.udea.test.modulogestionasientos.userinterfaces.PaginaReservas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidationVerDatosDeAsientos implements Question<Boolean> {
    public ValidationVerDatosDeAsientos(){}
    @Override
    public Boolean answeredBy(Actor actor) {
         return PaginaReservas.DISPONIBILIDAD_ASIENTOS.resolveFor(actor).isPresent()
            && PaginaReservas.CLASE.resolveFor(actor).isPresent()
            && PaginaReservas.SILLA.resolveFor(actor).isPresent()
            && PaginaReservas.UBICACION.resolveFor(actor).isPresent()
            && PaginaReservas.VALOR.resolveFor(actor).isPresent();
    }

    public static ValidationVerDatosDeAsientos seObservanLosDatosDeAsientos(){
        return new ValidationVerDatosDeAsientos();
    }
}
