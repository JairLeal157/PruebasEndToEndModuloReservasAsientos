package co.com.udea.test.modulogestionasientos.stepdefinitions;

import co.com.udea.test.modulogestionasientos.questions.ValidationBotonSeleccionar;
import co.com.udea.test.modulogestionasientos.questions.ValidationVerListaPasajeros;
import co.com.udea.test.modulogestionasientos.tasks.OpenThe;
import co.com.udea.test.modulogestionasientos.userinterfaces.PaginaReservas;
import co.com.udea.test.modulogestionasientos.utils.Constants2;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.Matchers.is;


import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class VerListaPasajerosStepDefinition {

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
    @Given("tengo una reserva")
    public void tengoUnaReserva(){
        this.numeroReserva = 123456;
    }
    @When("abro la pagina de la reserva")
    public void abroLaPaginaDeLaReserva(){
        usuario.attemptsTo(OpenThe.browser(new PaginaReservas()));
        String urlReserva = Constants2.LINK_TO_PAGINA_RESERVAS + this.numeroReserva;
        usuario.attemptsTo(Open.url(urlReserva));
    }
    @Then("veo todos los pasajeros de la reserva")
    public void veoTodosLosPasajerosDeLaReserva(){
        GivenWhenThen.then(usuario).should(GivenWhenThen.seeThat(ValidationVerListaPasajeros.ExisteListaPasajeros(), is(true)));
    }


    @And("para cada pasajero sin asiento, veo el texto {string} con la opción de seleccionar asiento para cada pasajero.")
    public void paraCadaPasajeroSinAsientoVeoElTextoConLaOpciónDeSeleccionarAsientoParaCadaPasajero(String noAsignado) {
        GivenWhenThen.then(usuario).should(GivenWhenThen.seeThat(ValidationBotonSeleccionar.existeSiNoHayAsientoAsignado(noAsignado), is(true)));
    }
}
