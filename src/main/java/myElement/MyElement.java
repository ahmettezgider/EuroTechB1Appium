package myElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import utils.Driver;
import utils.Utils;

public class MyElement {

    private AppiumDriver<?> driver = Driver.getDriver();
    private By locator;
    private MobileElement element;

    private MyElement(By locator){
        this.locator = locator;
    }

    private MyElement(String text){
        this.locator = Utils.getXpathWithAnyAttributeValue(text);
    }







}
