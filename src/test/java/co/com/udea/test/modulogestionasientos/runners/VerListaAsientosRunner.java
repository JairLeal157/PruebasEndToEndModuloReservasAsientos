package co.com.udea.test.modulogestionasientos.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/ver_lista_actualizada_de_asientos_disponibles.feature",
        glue = "co.com.udea.test.modulogestionasientos.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class VerListaAsientosRunner {

}