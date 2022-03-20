package ru.zavrichko.drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.zavrichko.config.SelenoidConfig;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class SelenoidMobileDriver implements WebDriverProvider {
    public static SelenoidConfig selenoid = ConfigFactory.create(SelenoidConfig.class, System.getProperties());

    public static URL getSelenoidUrl() {
        try {
            return new URL("https://" + selenoid.user() + ":" + selenoid.password() + "@" + selenoid.hubUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private URL getApkUrl() {
        try {
            return new URL(selenoid.app());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @CheckReturnValue
    @Nonnull
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("deviceName", selenoid.deviceName());
        mutableCapabilities.setCapability("version", selenoid.version());
        mutableCapabilities.setCapability("platformName", selenoid.platformName());
        mutableCapabilities.setCapability("locale", selenoid.locale());
        mutableCapabilities.setCapability("language", selenoid.language());
        mutableCapabilities.setCapability("app", getApkUrl());
        mutableCapabilities.setCapability("appPackage", selenoid.appPackage());
        mutableCapabilities.setCapability("appActivity", selenoid.appActivity());
        mutableCapabilities.setCapability("enableVNC", true);
        mutableCapabilities.setCapability("enableVideo", true);

        return new RemoteWebDriver(getSelenoidUrl(), mutableCapabilities);

    }
}
