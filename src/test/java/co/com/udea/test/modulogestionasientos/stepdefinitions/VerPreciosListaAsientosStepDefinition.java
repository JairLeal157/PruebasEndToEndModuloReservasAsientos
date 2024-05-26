package co.com.udea.test.modulogestionasientos.stepdefinitions;

import co.com.udea.test.modulogestionasientos.questions.ValidationVerPreciosDeAsientos;
import co.com.udea.test.modulogestionasientos.tasks.ClickThe;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static org.hamcrest.Matchers.is;

public class VerPreciosListaAsientosStepDefinition {

    //actor
    private final Actor usuario = Actor.named("usuario");

    //driver
    @Managed(driver="chrome", uniqueSession = true)
    public WebDriver theDriver;

    //Variables
    private int numeroReserva;

    //inicializar
    @Before
    public void init(){
        usuario.can(BrowseTheWeb.with(theDriver));
        setTheStage(new OnlineCast());
    }

    @When("abro la lista de asientos disponibles")
    public void abroLaListaDeAsientosDisponibles() {
        usuario.attemptsTo(ClickThe.BotonSeleccionar());
    }

    @Then("debo ver el precio adicional de cada asiento en la lista en formato COP")
    public void deboVerElPrecioAdicionalDeCadaAsientoEnLaListaEnFormatoCOP() {
        GivenWhenThen.then(usuario).should(GivenWhenThen.seeThat(ValidationVerPreciosDeAsientos.seObservaLosPreciosDeLosAsientos(),  is(true)));
    }
}
