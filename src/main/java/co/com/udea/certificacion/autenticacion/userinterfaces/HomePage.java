package co.com.udea.certificacion.autenticacion.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage extends PageObject {

    public static final Target INPUT_TEXT = Target.the("texto de entrada").locatedBy("//*[@name='q']");
    public static final  Target LINK_TO_UDEA_HOMEPAGE =Target.the("el link udea").locatedBy("//h3[contains(@class, 'LC20lb MBeuO DKV0Md')]");
    public static final  Target TITLE_UDEA_HOMEPAGE =Target.the("el link udea").locatedBy("//*[@id='layoutContainers']/div/div[2]/div/div[2]/section/div[2]/section[1]/div[1]/p");




}