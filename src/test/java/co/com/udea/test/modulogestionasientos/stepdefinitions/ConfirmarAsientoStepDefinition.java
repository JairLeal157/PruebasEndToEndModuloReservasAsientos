package co.com.udea.test.modulogestionasientos.stepdefinitions;

import co.com.udea.test.modulogestionasientos.questions.ValidationVerConfirmacionAsiento;
import co.com.udea.test.modulogestionasientos.tasks.ClickThe;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
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

public class ConfirmarAsientoStepDefinition {
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
    @When("selecciono y confirmo un asiento disponible para un pasajero")
    public void seleccionoYConfirmoUnAsientoDisponibleParaUnPasajero() {
        usuario.attemptsTo(ClickThe.BotonSeleccionar());
        usuario.attemptsTo(ClickThe.BotonAsiento());
        usuario.attemptsTo(ClickThe.BotonSeleccionarAsiento());
    }

    @Then("debo recibir un aviso informando que el asiento quedó confirmado")
    public void deboRecibirUnAvisoInformandoQueElAsientoQuedóConfirmado() {
        GivenWhenThen.then(usuario).should(GivenWhenThen.seeThat(ValidationVerConfirmacionAsiento.estaPresente(), is(true)));
    }

    @And("el asiento seleccionado debe quedar ocupado")
    public void elAsientoSeleccionadoDebeQuedarOcupado() {
        usuario.attemptsTo(ClickThe.BotonSeleccionar());

    }
}
