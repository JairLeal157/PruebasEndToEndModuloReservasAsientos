package co.com.udea.test.modulogestionasientos.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Confirmar_asiento_por_pasajero.feature",
        glue = "co.com.udea.test.modulogestionasientos.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class ConfirmarAsientoRunner {

}