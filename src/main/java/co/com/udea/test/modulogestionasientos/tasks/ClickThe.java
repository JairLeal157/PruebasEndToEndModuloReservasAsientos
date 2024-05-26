package co.com.udea.test.modulogestionasientos.tasks;

import co.com.udea.test.modulogestionasientos.interactions.ClickBoton;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ClickThe implements Task {

    private final ClickBoton boton;

    public ClickThe(ClickBoton boton) {
        this.boton = boton;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(boton);
    }

    public static ClickThe BotonSeleccionar() {
        return Tasks.instrumented(ClickThe.class, ClickBoton.seleccionar());
    }

    public static ClickThe BotonAsiento() {
        return Tasks.instrumented(ClickThe.class, ClickBoton.asiento());
    }

    public static ClickThe BotonSeleccionarAsiento() {
        return Tasks.instrumented(ClickThe.class, ClickBoton.seleccionarAsiento());
    }
}
