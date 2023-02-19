package batch2.cucumber;

import batch2.testng.Locators;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.App;
import utils.Device;
import utils.Driver;
import utils.ElementStatus;

import static utils.Actions.action;
import static utils.Utils.openApp;

public class CucumberSteps implements Locators {

    AppiumDriver<?> driver;

    @Given("open App")
    public void userOpenApp() {
        openApp(Device.SAMSUNG_A33, App.APIDEMO);
        action.click(startupContinueButton);
        action.click(startupPopupOkButton);
        action.click(startupLogOkButton);
    }

    @When("click link with text as {string}")
    public void userClicksLinkWithTextAs(String text) {
        action.click(getXpathOfText(text));
    }

    @And("swipe down until {string} is visible")
    public void swipeDownUntilIsVisible(String text) {
        action.swipeUntil(getXpathOfText(text));
    }

    @And("click link with partial value as {string}")
    public void userClicksLinkWithPartialValueAs(String partialText) {
        action.click(getXpathWithAnyAttributeValue(partialText));
    }

    @And("sendkeys {string} to element with partial value {string}")
    public void sendkeysToElementWithPartialValue(String textToSend, String value) {
        action.sendkeys(getXpathWithAnyAttributeValue(value), textToSend);
    }

    @And("hide keyboard")
    public void hideKeyboard() {
        Driver.getDriver().hideKeyboard();
    }

    @And("is element {string} with partial value {string}")
    public void isElementWithPartialValue(String status, String partialValue) {
        if (ElementStatus.valueOf(status).ordinal()>0) {
            Assert.assertTrue(
                    action.getAttribute(getXpathWithAnyAttributeValue(partialValue),
                            ElementStatus.valueOf(status))
            );
        }else{
            switch (status.toLowerCase()){
                case "enabled":
                    Assert.assertTrue(
                            action.getElement(getXpathWithAnyAttributeValue(partialValue)).isEnabled()
                    );
                case "selected":
                    Assert.assertTrue(
                            action.getElement(getXpathWithAnyAttributeValue(partialValue)).isSelected()
                    );
                default:
                    Assert.assertTrue(
                            action.getElement(getXpathWithAnyAttributeValue(partialValue)).isDisplayed()
                    );
            }
        }
    }

    @And("quit App")
    public void quitApp() {
        Driver.quitDriver();
        Driver.stopAppium();
    }
}
