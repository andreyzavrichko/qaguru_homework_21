//package ru.zavrichko.drivers;
//
//import com.codeborne.selenide.WebDriverProvider;
//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import ru.zavrichko.config.Credentials;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class BrowserstackMobileDriver implements WebDriverProvider {
//
//    public static URL getBrowserstackUrl() {
//        try {
//            return new URL("http://hub.browserstack.com/wd/hub");
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public WebDriver createDriver(DesiredCapabilities caps) {
//
//        // Set your access credentials
//        String user = Credentials.config.user();
//        String key = Credentials.config.key();
//        String app = Credentials.config.app();
//        caps.setCapability("browserstack.user", user);
//        caps.setCapability("browserstack.key", key);
//
//        // Set URL of the application under test
//        caps.setCapability("app", app);
//
//        // Specify device and os_version for testing
//        caps.setCapability("device", "Google Pixel 3");
//        caps.setCapability("os_version", "9.0");
//
//        // Set other BrowserStack capabilities
//        caps.setCapability("project", "First Java Project");
//        caps.setCapability("build", "browserstack-build-1");
//        caps.setCapability("name", "first_test");
//
//
//        return new AndroidDriver(getBrowserstackUrl(), caps);
//    }
//}
