package co.com.udea.certificacion.autenticacion.interactions;

import co.com.udea.certificacion.autenticacion.userinterfaces.PaginaReservas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class ClickBoton implements Interaction {

        @Override
        public <T extends Actor> void performAs(T actor) {
                actor.attemptsTo(Click.on(PaginaReservas.BOTON_SELECCIONAR));
        }

        public static ClickBoton seleccionar() {
                return  Tasks.instrumented(ClickBoton.class);
        }
}
