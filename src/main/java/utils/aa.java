package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.print.PrinterGraphics;
import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class aa {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, 10);
    public String name;
    public void method1(){

    }

    public static void main(String[] args) {
        // a   b     c
        String str = new Scanner(System.in).nextLine();
        System.out.println(
                str.replaceAll("[ ]+", " ").trim().split(" ")[1]
        );
    }


    @Test
    public void readScanner(){

        String str = "";

        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();

        str = new Scanner(System.in).nextLine();

        System.out.println(str);
    }

    @Test
    public void main1() {
        Object[] arr = new Object[3];
        arr[0] = 1;
        arr[1] = "text";
        arr[2] = new Driver();

        for (Object o : arr) {
            System.out.println(o);
        }

        int[] arr1;

        Driver d1 = new Driver();
        Scanner scanner = new Scanner(System.in);

        Object[] arr2 = {d1, new aa(), new Scanner(System.in), scanner};

        System.out.println( ((aa)arr2[1]).name);
        System.out.println( ((Scanner)arr2[2]));

        ((Scanner)arr2[3]).nextLine();




    }


    @Test
    public void xpath(){
        String xpathString = "//input[./ancestor::div[contains(@class,\"{0}\")]//label[contains(text(), \"{1}\")]]";

        By xpath = By.xpath(MessageFormat.format(xpathString, "oxd-input-field", "Username"));


        List<WebElement> list = driver.findElements(xpath);

        list.stream().filter(x -> x.isDisplayed()).toList().get(0).click();
    }

    @Test
    public void stream1(){
        ArrayList<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));


        list.stream().filter( n -> n % 2 == 1).forEach(n -> {
            for (int i = 0; i < n; i++) {
                System.out.print("*");
            }
            System.out.println();
        });
        list.forEach(System.out::println);

    }

    @Test
    public void dwait(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        By by1 = By.xpath("(//input | //p)");
        By by2 = By.xpath("");



        wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(by1), ExpectedConditions.visibilityOfElementLocated(by2)));

        wait.until(ExpectedConditions.elementToBeClickable(by1));
        wait.until(driver -> {
            try{
                driver.findElement(by1).click();
                return true;
            }catch (Exception e){
                return false;
            }
        });

        wait.until(driver -> {
            try{
                if (driver.findElements(by1).stream().filter(e->e.isDisplayed()).toList().size()>0)
                    return true;
                return false;
            }catch (Exception e){
                return false;
            }
        });

        wait.until(aa::method);

    }

    public static boolean method(WebDriver driver){
        try{
            if (driver.findElements(By.xpath("")).stream().filter(e->e.isDisplayed()).toList().size()>0)
                return true;
            return false;
        }catch (Exception e){
            return false;
        }
    }
}
