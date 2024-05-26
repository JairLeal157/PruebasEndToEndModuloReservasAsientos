package co.com.udea.test.modulogestionasientos.interactions;

import co.com.udea.test.modulogestionasientos.userinterfaces.PaginaReservas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;


public class ClickBoton implements Interaction {

    private final Target boton;

    public ClickBoton(Target boton) {
        this.boton = boton;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(boton));
    }

    public static ClickBoton seleccionar() {
        return  Tasks.instrumented(ClickBoton.class, PaginaReservas.BOTON_SELECCIONAR);
    }

    public static ClickBoton asiento() {
        return  Tasks.instrumented(ClickBoton.class, PaginaReservas.ASIENTO);
    }

    public static ClickBoton seleccionarAsiento() {
        return  Tasks.instrumented(ClickBoton.class, PaginaReservas.BOTON_SELECCIONAR_ASIENTO);
    }




}
