package co.com.udea.test.modulogestionasientos.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/ver_precios_de_los_asientos_en_la_seleccion.feature",
        glue = "co.com.udea.test.modulogestionasientos.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class VerPreciosAsientosRunner {

}