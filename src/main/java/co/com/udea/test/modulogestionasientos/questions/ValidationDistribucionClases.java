package co.com.udea.test.modulogestionasientos.questions;

import co.com.udea.test.modulogestionasientos.userinterfaces.PaginaReservas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

import java.util.List;

public class ValidationDistribucionClases implements Question<Boolean> {
    private  int porcentajeTuristas;
    private  int porcentajePrimeraClase;
    private  int porcentajeEjecutiva;

    public ValidationDistribucionClases(int porcentajeTuristas, int porcentajePrimeraClase, int porcentajeEjecutiva){
        this.porcentajeTuristas = porcentajeTuristas;
        this.porcentajePrimeraClase = porcentajePrimeraClase;
        this.porcentajeEjecutiva = porcentajeEjecutiva;
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        List<String> clasesAsientos = (List<String>) TextContent.ofEach(PaginaReservas.ASIENTOS_DE_LA_LISTA_DE_ASIENTOS).answeredBy(actor);

        long totalAsientos = clasesAsientos.size();
        long contadorTurista = clasesAsientos.stream().filter(clase -> clase.equalsIgnoreCase("Turista")).count();
        long contadorPrimeraClase = clasesAsientos.stream().filter(clase -> clase.equalsIgnoreCase("Primera Clase")).count();
        long contadorEjecutiva = clasesAsientos.stream().filter(clase -> clase.equalsIgnoreCase("Ejecutivo")).count();

        // Calcular los porcentajes reales
        int porcentajeRealTurista = (int) (contadorTurista *100  / totalAsientos) ;
        int porcentajeRealPrimeraClase = (int) (contadorPrimeraClase*100 / totalAsientos) ;
        int porcentajeRealEjecutiva = (int) (contadorEjecutiva*100 / totalAsientos) ;

        return porcentajeRealTurista == porcentajeTuristas
                && porcentajeRealPrimeraClase == porcentajePrimeraClase
                && porcentajeRealEjecutiva == porcentajeEjecutiva;

    }

    public static ValidationDistribucionClases seDistribuyenLosAsientosDeLaSiguienteManera(int porcentajeTuristas, int porcentajePrimeraClase, int porcentajeEjecutiva){
        return new ValidationDistribucionClases(porcentajeTuristas, porcentajePrimeraClase, porcentajeEjecutiva);
    }
}
