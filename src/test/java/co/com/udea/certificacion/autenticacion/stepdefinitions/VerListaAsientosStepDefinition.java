package co.com.udea.certificacion.autenticacion.stepdefinitions;

import co.com.udea.certificacion.autenticacion.interactions.ClickBoton;
import co.com.udea.certificacion.autenticacion.questions.ValidationVerListaAsientos;
import co.com.udea.certificacion.autenticacion.questions.ValidationVerListaPasajeros;
import co.com.udea.certificacion.autenticacion.tasks.ClickThe;
import co.com.udea.certificacion.autenticacion.utils.Constants2;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static org.hamcrest.Matchers.is;

public class VerListaAsientosStepDefinition {

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

    @Given("no tengo asiento asignado")
    public void noTengoAsientoAsignado() {
        numeroReserva = 123456; // un número de reserva que no tiene asientos sin asignar
    }

    @And("estoy en la página de gestión de asientos de la reserva")
    public void estoyEnLaPáginaDeGestiónDeAsientosDeLaReserva() {
        String urlReserva = Constants2.LINK_TO_PAGINA_RESERVAS + numeroReserva;
        usuario.attemptsTo(Open.url(urlReserva));
    }

    @When("selecciono la opción de seleccionar asiento para un pasajero")
    public void seleccionoLaOpciónDeSeleccionarAsientoParaUnPasajero() {
        usuario.attemptsTo(ClickThe.BotonSeleccionar());
    }

    @Then("veo la lista de asientos disponibles")
    public void veoLaListaDeAsientosDisponibles() {
        GivenWhenThen.then(usuario).should(GivenWhenThen.seeThat(ValidationVerListaAsientos.seObservanAsientos(), is(true)));
    }

    @And("veo el número de asiento, la clase y la ubicación para cada asiento")
    public void veoElNúmeroDeAsientoLaClaseYLaUbicaciónParaCadaAsiento() {
    }

    @And("la lista está ordenada alfabéticamente según la información del asiento")
    public void laListaEstáOrdenadaAlfabéticamenteSegúnLaInformaciónDelAsiento() {
    }

    @And("para cada asiento asignado por mi reserva, veo el número de reserva y el nombre del pasajero")
    public void paraCadaAsientoAsignadoPorMiReservaVeoElNúmeroDeReservaYElNombreDelPasajero() {
    }

    @And("el {int}% de los asientos disponibles corresponden a clase turista, el {int}% a primera clase y el {int}% a clase ejecutiva")
    public void elDeLosAsientosDisponiblesCorrespondenAClaseTuristaElAPrimeraClaseYElAClaseEjecutiva(int arg0, int arg1, int arg2) {
    }

    @And("la distribución de ubicaciones \\(ventana, pasillo y centro) es equitativa para cada clase")
    public void laDistribuciónDeUbicacionesVentanaPasilloYCentroEsEquitativaParaCadaClase() {
    }

    @But("no se muestra información de los asientos ocupados por otras reservas.")
    public void noSeMuestraInformaciónDeLosAsientosOcupadosPorOtrasReservas() {
    }
}
