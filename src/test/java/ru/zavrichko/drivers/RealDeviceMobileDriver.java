package ru.zavrichko.drivers;


import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.zavrichko.config.RealDeviceConfig;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.net.MalformedURLException;
import java.net.URL;


@ParametersAreNonnullByDefault
public class RealDeviceMobileDriver implements WebDriverProvider {
    public static RealDeviceConfig realDevice = ConfigFactory.create(RealDeviceConfig.class, System.getProperties());

    public static URL getRealDeviceUrl() {
        try {
            return new URL(realDevice.hubUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    @CheckReturnValue
    @Nonnull
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("deviceName", realDevice.deviceName());
        mutableCapabilities.setCapability("version", realDevice.version());
        mutableCapabilities.setCapability("platformName", realDevice.platformName());
        mutableCapabilities.setCapability("locale", realDevice.locale());
        mutableCapabilities.setCapability("language", realDevice.language());
        mutableCapabilities.setCapability("appPackage", realDevice.appPackage());
        mutableCapabilities.setCapability("appActivity", realDevice.appActivity());
        mutableCapabilities.setCapability("appium:appWaitForLaunch", false);

        return new RemoteWebDriver(getRealDeviceUrl(), mutableCapabilities);
    }
}
