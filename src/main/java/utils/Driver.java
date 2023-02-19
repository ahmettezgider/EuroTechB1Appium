package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {

    private static final ThreadLocal<AppiumDriver<MobileElement>> drivers = new ThreadLocal<>();
    static AppiumDriverLocalService service;


    public static void runAppium(){
        service = new AppiumServiceBuilder()
                //.withLogFile(new File("appium.log"))
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .build();
        service.clearOutPutStreams();
        service.start();
    }

    public static void stopAppium(){
        service.stop();
    }

    public static AppiumDriver<?> getDriver(Device device, App app){
        drivers.set(new AndroidDriver<>(service.getUrl(), setCaps(device, app)));
        return drivers.get();

    }



    private static DesiredCapabilities setCaps(Device device, App app){
        String apk = "src/main/resources/";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:udid", device.getUdid());
        capabilities.setCapability("appium:version", device.getVersion());
        capabilities.setCapability("appium:deviceName", device.getDeviceName());
        capabilities.setCapability("platformName", device.getPlatformName());
        if (app.getApk().length()>0)
            capabilities.setCapability("appium:app", apk + app.getApk());


        capabilities.setCapability("appium:appPackage", app.getAppPackage());
        capabilities.setCapability("appium:appActivity", app.getAppActivity());
        return capabilities;
    }

    public static AppiumDriver<?> getDriver(){
        return drivers.get();
    }

    public static void quitDriver(){
        drivers.get().closeApp();
    }

}
