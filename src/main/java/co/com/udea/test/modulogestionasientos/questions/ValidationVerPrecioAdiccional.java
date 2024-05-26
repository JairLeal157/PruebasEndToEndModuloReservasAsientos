package co.com.udea.test.modulogestionasientos.questions;

import co.com.udea.test.modulogestionasientos.userinterfaces.PaginaReservas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidationVerPrecioAdiccional implements Question<Boolean> {
    public ValidationVerPrecioAdiccional(){}
    @Override
    public Boolean answeredBy(Actor actor) {
        String precioAdiccional = PaginaReservas.PRECIO_ADICIONAL.resolveFor(actor).getText();
        return precioAdiccional.contains("$");
    }

    public static ValidationVerPrecioAdiccional seObservaPrecioAdiccional(){
        return new ValidationVerPrecioAdiccional();
    }
}
