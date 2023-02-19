package batch2.testng;

import org.openqa.selenium.By;

public interface Locators {
    By startupContinueButton = By.id("com.android.permissioncontroller:id/continue_button");
    By startupPopupOkButton = By.id("android:id/button1");
    By startupLogOkButton = By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive");

    default By getXpathOfText(String text){
        return By.xpath("//*[contains(@text,\"" + text + "\")]");
    }

    default By getXpathWithAnyAttributeValue(String text){
        return By.xpath("//*[@*[contains(.,\"" + text + "\")]]");
    }
}
