package batch2.testng;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.*;

import java.util.Random;

import static utils.Actions.*;

import static utils.Utils.openApp;

public class Odevler implements Locators {

    AppiumDriver<?> driver;

    @BeforeTest
    public void beforeTest(){
        openApp(Device.SAMSUNG_A33, App.APIDEMO);
        driver = Driver.getDriver();
        action.click(startupContinueButton);
        action.click(startupPopupOkButton);
        action.click(startupLogOkButton);

    }

    @AfterTest
    public void afterTest(){
        Driver.quitDriver();
        Driver.stopAppium();

    }

    @Test
    public void scenario1(){
        /*
            1.	Scenario 1
            a.	API Demos->Views->Controls'a tiklayin
            b.	Light Theme'e tiklayin
            c.	Checkbox1'e tiklayin ve checked oldugunu assert edin
            d.	RadioButton1'e tiklayin  ve checked oldugunu assert edin
            e.	Star'a  tiklayin  ve checked oldugunu assert edin
            f.	Ilk button'a  tiklayin ve textinin ON, statüsünün checked oldugunu assert edin
            g.	Ikinci button'un textinin OFF, statüsünün unchecked oldugunu assert edin
         */
        action.click(getXpathOfText("API Demos"));
        action.swipeUntil(getXpathOfText("View"));
        action.click(getXpathOfText("View"));
        action.click(getXpathOfText("Controls"));
        action.click(getXpathOfText("Light Theme"));
        By textBox = By.id("com.touchboarder.android.api.demos:id/edit");
        action.sendkeys(textBox, "textbox");
        driver.hideKeyboard();
        By checkbox1 = By.id("com.touchboarder.android.api.demos:id/check1");
        By checkbox2 = By.id("com.touchboarder.android.api.demos:id/check2");
        action.click(checkbox1);
        Assert.assertTrue(action.getElement(checkbox1).isDisplayed());
        Assert.assertTrue(action.getAttribute(checkbox1, ElementStatus.checked));

        By radio1 = By.id("com.touchboarder.android.api.demos:id/radio1");
        By radio2 = By.id("com.touchboarder.android.api.demos:id/radio2");
        action.click(radio1);
        Assert.assertTrue(action.getAttribute(radio1, ElementStatus.displayed));
        Assert.assertTrue(action.getAttribute(radio1, ElementStatus.checked));


        By star = By.id("com.touchboarder.android.api.demos:id/star");
        action.click(star);
        Assert.assertTrue(action.getAttribute(star, ElementStatus.checked));

        By toggle1 = By.id("com.touchboarder.android.api.demos:id/toggle1");
        By toggle2 = By.id("com.touchboarder.android.api.demos:id/toggle2");
        action.click(toggle1);
        Assert.assertTrue(action.getAttribute(toggle1, ElementStatus.checked));
        Assert.assertFalse(action.getAttribute(toggle2, ElementStatus.checked));

        By select = By.id("com.touchboarder.android.api.demos:id/spinner1");
        action.click(select);

        action.click(getXpathOfText("Earth"));
        By selectText = By.id("android:id/text1");
        Assert.assertTrue(action.getElement(selectText).getText().equalsIgnoreCase("Earth"));

    }

    @Test
    public void scenario2(){
        /*
        2.    Scenario 2
            a.    API Demos->Views->Expandable List'e tiklayin
            b.    Custom Adaptor'e tiklayin
            c.    Custom Adaptor'e tiklayin ve 4 adet ismin visible oldugunu assert edin
            d.    People Names'e tekrar tiklayin ve 4 adet ismin invisible oldugunu assert edin
            e.    Fish Names'e tiklayin ve ikinci siradaki ismin Bubbles oldugunu assert edin.
         */
        action.click(getXpathOfText("API Demos"));
        action.swipeUntil(getXpathOfText("View"));
        action.click(getXpathOfText("Views"));
        action.click(getXpathOfText("Expandable Lists"));
        action.click(getXpathOfText("Custom Adapter"));
        Assert.assertEquals(driver.findElements(By.xpath("//*[@*='android:id/list']/*")).size(),4);
        action.click(getXpathOfText("Fish Names"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@*='Fish Names']/following-sibling::*[2]")).getText().equalsIgnoreCase("Bubbles"));
    }

    @Test
    public void scenario3(){
        /*
        3. Scenario 3
         a.    10 ile 20 arasinda random bir sayi secin
         b.    API Demos->Views->TextSwitcher'a tiklayin
         c.    Secilen random sayiya gelinceye kadar Next butonuna tiklayin
         d.    Istenilen sayiya ulasilinca navigate().back() ile geri gelin.
         */
        int randomNum = new Random().nextInt(10, 20);
        System.out.println(randomNum);
        action.click(getXpathOfText("API Demos"));

        By views = getXpathOfText("View");
        action.swipeUntil(views);
        action.click(views);

        By textSwitcher = getXpathOfText("TextSwitcher");
        action.swipeUntil(textSwitcher);
        action.click(textSwitcher);

        By nextButton = getXpathWithAnyAttributeValue("id/next");
        By numField = getXpathWithAnyAttributeValue("id/switcher");
        String text;
        do {
            action.click(nextButton);
             text = driver.findElement(By.xpath("//android.widget.TextSwitcher/android.widget.TextView")).getText();
             System.out.println(text);
        }while (!text.equalsIgnoreCase(randomNum+""));

        while (driver.findElements(getXpathOfText("API Demos")).size()==0)
            driver.navigate().back();
    }

    @Test
    public void scenarioWebView(){

        action.click(getXpathOfText("API Demos"));
        action.swipeUntil(getXpathOfText("View"));
        action.click(getXpathOfText("View"));
        action.swipeUntil(getXpathOfText("WebView"));
        action.click(getXpathOfText("WebView"));

        action.getElement(getXpathWithAnyAttributeValue("Hello World")).click();
        action.waitFor(getXpathWithAnyAttributeValue("Hello World"), Conditions.invisibility);
    }
}
