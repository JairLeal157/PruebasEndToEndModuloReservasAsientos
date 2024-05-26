package co.com.udea.test.modulogestionasientos.stepdefinitions;

import co.com.udea.test.modulogestionasientos.questions.ValidationPrecioSinAsiento;
import co.com.udea.test.modulogestionasientos.questions.ValidationVerPrecioAdiccional;
import co.com.udea.test.modulogestionasientos.questions.ValidationVerPreciosDeAsientosPasajeros;
import co.com.udea.test.modulogestionasientos.tasks.ClickThe;

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

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static org.hamcrest.Matchers.is;

public class VerPreciosListaPasajerosStepDefinition {

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

    @Given("que tengo una reserva con pasajeros")
    public void queTengoUnaReservaConPasajeros(){
        this.numeroReserva = 123456;
    }
    @When("selecciono los asientos")
    public void seleccionoLosAsientos(){
        usuario.attemptsTo(ClickThe.BotonSeleccionar());
        usuario.attemptsTo(ClickThe.BotonAsiento());
        usuario.attemptsTo(ClickThe.BotonSeleccionarAsiento());
    }
    @Then("debo ver en la lista de pasajeros los precios de los asientos seleccionados en formato COP")
    public void deboVerEnLaListaDePasajerosLosPreciosDeLosAsientosSeleccionadosEnFormatoCOP(){
        GivenWhenThen.then(usuario).should(GivenWhenThen.seeThat(ValidationVerPreciosDeAsientosPasajeros.seObservaLosPreciosDeLosAsientos(), is(true)));

    }

    @And("debo ver el total adicional de la reserva por los asientos")
    public void deboVerElTotalAdicionalDeLaReservaPorLosAsientos() {
        GivenWhenThen.then(usuario).should(GivenWhenThen.seeThat(ValidationVerPrecioAdiccional.seObservaPrecioAdiccional(), is(true)));

    }

    @Given("que tengo una reserva con pasajeros pero uno o mas no tienen asientos seleccionados")
    public void queTengoUnaReservaConPasajerosPeroUnoOMasNoTienenAsientosSeleccionados() {
        usuario.attemptsTo(OpenThe.browser(new PaginaReservas()));
        String urlReserva = Constants2.LINK_TO_PAGINA_RESERVAS + this.numeroReserva;
        usuario.attemptsTo(Open.url(urlReserva));
    }

    @Then("debo ver la lista de precios de asientos por cada pasajero en formato COP")
    public void deboVerLaListaDePreciosDeAsientosPorCadaPasajeroEnFormatoCOP() {
        GivenWhenThen.then(usuario).should(GivenWhenThen.seeThat(ValidationVerPreciosDeAsientosPasajeros.seObservaLosPreciosDeLosAsientos(), is(true)));
    }

    @And("debo ver que los pasajeros sin asientos tengan un valor de {int}")
    public void deboVerQueLosPasajerosSinAsientosTenganUnValorDe(int arg0) {
        GivenWhenThen.then(usuario).should(GivenWhenThen.seeThat(ValidationPrecioSinAsiento.precioEsCeroSiNoHayAsientoAsignado(arg0), is(true)));

    }


}
