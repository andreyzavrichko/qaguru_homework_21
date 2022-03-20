package ru.zavrichko.helpers;

import ru.zavrichko.drivers.BrowserstackMobileDriver;
import ru.zavrichko.drivers.LocalMobileDriver;

public class DeviceSelection {
    public static String getDeviceDriver(String deviceHost) {

        switch (deviceHost) {
            case "emulation":
                return LocalMobileDriver.class.getName();
            case "browserstack":
                return BrowserstackMobileDriver.class.getName();


            default:
                throw new RuntimeException("Please select only " +
                        "emulation / browserstack / -DdeviceHost parameter");
        }
    }
}
