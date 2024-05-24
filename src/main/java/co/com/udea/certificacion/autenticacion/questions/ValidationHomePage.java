package co.com.udea.certificacion.autenticacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.com.udea.certificacion.autenticacion.userinterfaces.HomePage.TITLE_UDEA_HOMEPAGE;

public class ValidationHomePage implements Question<String> {

    public ValidationHomePage(){}
    @Override
    public String answeredBy(Actor actor) {
     String msg = BrowseTheWeb.as(actor).find(TITLE_UDEA_HOMEPAGE).getText();
     return msg;
    }

    public static ValidationHomePage titleUdeA(){
        return new ValidationHomePage();
    }
}