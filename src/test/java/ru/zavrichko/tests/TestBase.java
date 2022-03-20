package ru.zavrichko.tests;

import com.codeborne.selenide.Configuration;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.zavrichko.helpers.Attach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

import static ru.zavrichko.helpers.Attach.*;
import static ru.zavrichko.helpers.DeviceSelection.getDeviceDriver;

public class TestBase {
    private static final String deviceHost = System.getProperty("deviceHost");

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = getDeviceDriver(deviceHost);
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
        Attach.video(sessionId);
    }

}
