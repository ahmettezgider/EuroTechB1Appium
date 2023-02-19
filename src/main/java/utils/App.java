package utils;

import lombok.Getter;

public enum App {

    APIDEMO("com.touchboarder.android.api.demos","com.touchboarder.androidapidemos.MainActivity", "ApiDemos.zip"),
    CALCULATOR("com.sec.android.app.popupcalculator","Calculator", "")
    ;
    @Getter
    private String appPackage;
    @Getter
    private String appActivity;
    @Getter
    private String apk;


    App(String appPackage, String appActivity, String apk) {
        this.appPackage = appPackage;
        this.appActivity = appActivity;
        this.apk = apk;
    }




}
