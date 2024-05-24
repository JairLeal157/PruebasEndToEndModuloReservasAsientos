package co.com.udea.certificacion.autenticacion.stepdefinitions;

import co.com.udea.certificacion.autenticacion.questions.ValidationHomePage;
import co.com.udea.certificacion.autenticacion.tasks.FindThe;
import co.com.udea.certificacion.autenticacion.tasks.OpenThe;
import co.com.udea.certificacion.autenticacion.userinterfaces.HomePage;
import co.com.udea.certificacion.autenticacion.utils.Constants2;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class FindOutStepDefinition {

    //actor
    private final Actor comercial = Actor.named("Admon");

    //driver
    @Managed(driver="chrome", uniqueSession = true)
    public WebDriver theDriver;

    //inicializar
    @Before
    public void init(){
        comercial.can(BrowseTheWeb.with(theDriver));
        setTheStage(new OnlineCast());
    }

    @Given("estoy en la sitio de google")
    public void estoyEnelSitio(){
        comercial.attemptsTo(OpenThe.browser(new HomePage()));
    }
    @When("digite la palabra clave UdeA")
    public void digiteLaPalabraClave(){
       comercial.attemptsTo(FindThe.wordKey());
    }
    @Then("puedo visualizar el link de la pagina oficial de la udea")
    public void puedoVisualizarLink(){
        GivenWhenThen.then(comercial).should(GivenWhenThen.seeThat(ValidationHomePage.titleUdeA(), Matchers.containsString(Constants2.VAL1)));
    }


}
