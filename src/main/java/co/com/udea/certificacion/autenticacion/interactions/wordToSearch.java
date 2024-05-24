package co.com.udea.certificacion.autenticacion.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static co.com.udea.certificacion.autenticacion.userinterfaces.HomePage.INPUT_TEXT;
import static co.com.udea.certificacion.autenticacion.userinterfaces.HomePage.LINK_TO_UDEA_HOMEPAGE;

public class wordToSearch implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue("U de A").into(INPUT_TEXT).thenHit(Keys.RETURN));
        actor.attemptsTo(Click.on(LINK_TO_UDEA_HOMEPAGE));
    }

    public static wordToSearch inTextArea(){
        return Tasks.instrumented(wordToSearch.class);
    }
}