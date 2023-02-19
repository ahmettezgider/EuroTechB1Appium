package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class Utils {


    public static AppiumDriver<?> openApp(Device device, App app){
        Driver.runAppium();
        return Driver.getDriver(device, app);
    }

    public static By getXpathOfText(String text){
        return By.xpath("//*[contains(@text,\"" + text + "\")]");
    }

    public static By getXpathWithAnyAttributeValue(String text) {
        return By.xpath("//*[@*[contains(.,\"" + text + "\")]]");
    }
}
