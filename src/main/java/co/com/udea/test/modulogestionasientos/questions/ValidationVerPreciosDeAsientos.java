package co.com.udea.test.modulogestionasientos.questions;

import co.com.udea.test.modulogestionasientos.userinterfaces.PaginaReservas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

import java.util.List;

public class ValidationVerPreciosDeAsientos implements Question<Boolean> {
    public ValidationVerPreciosDeAsientos(){}
    @Override
    public Boolean answeredBy(Actor actor) {
        List<String> asientos = TextContent.ofEach(PaginaReservas.LISTA_ASIENTOS).answeredBy(actor).stream().toList();
        for (String asiento : asientos) {
            boolean precio = asiento.contains("$");
            if (!precio) {
                return false;
            }
        }
        return true;
    }

    public static ValidationVerPreciosDeAsientos seObservaLosPreciosDeLosAsientos(){
        return new ValidationVerPreciosDeAsientos();
    }
}
