package utils;

import lombok.Getter;

public enum Device {

    PIXEL2("emulator-5554",
            "11",
            "Pixel2",
            "Android"),
    SAMSUNG_A33(
            "RZCT40MN7MY",
            "12",
            "My Phone",
            "Android");

    @Getter
    private String udid;
    @Getter
    private String version;
    @Getter
    private String deviceName;
    @Getter
    private String platformName;

    Device(String udid, String version, String deviceName, String platformName) {
        this.udid = udid;
        this.version = version;
        this.deviceName = deviceName;
        this.platformName = platformName;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
