package ru.zavrichko.tests;

import com.codeborne.selenide.Configuration;

import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.zavrichko.config.CredentialsConfig;
import ru.zavrichko.drivers.BrowserstackMobileDriver;
import ru.zavrichko.drivers.LocalMobileDriver;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

import static ru.zavrichko.helpers.Attach.*;

public class TestBase {
    static final CredentialsConfig Config = ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());

        switch (Config.device().toLowerCase()) {
            case "browserstack":
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                break;
            case "emulation":
                Configuration.browser = LocalMobileDriver.class.getName();
                break;
            default:
                throw new IllegalArgumentException(
                        String.format("Unknown device name=%s. " +
                                "-Ddevice.name=[Browserstack/Emulation]", Config.device()));
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void beforeEach() {
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = getSessionId();
        screenshotAs("Last screenshot");
        pageSource();

        closeWebDriver();
        switch (Config.device().toLowerCase()) {
            case "browserstack":
                video(sessionId);
                break;

        }
    }

}
