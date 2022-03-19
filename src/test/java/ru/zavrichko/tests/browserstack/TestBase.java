//package ru.zavrichko.tests.browserstack;
//
//import com.codeborne.selenide.Configuration;
//import io.qameta.allure.selenide.AllureSelenide;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import ru.zavrichko.drivers.BrowserstackMobileDriver;
//import ru.zavrichko.helpers.Attach;
//import static com.codeborne.selenide.Selenide.closeWebDriver;
//import static com.codeborne.selenide.Selenide.open;
//import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
//
//import static ru.zavrichko.helpers.Attach.getSessionId;
//
//
//public class TestBase {
//    @BeforeAll
//    public static void setup() {
//        addListener("AllureSelenide", new AllureSelenide());
//
//        Configuration.browser = BrowserstackMobileDriver.class.getName();
////        Configuration.startMaximized = false;
//        Configuration.browserSize = null;
//    }
//
//    @BeforeEach
//    public void startDriver() {
//        open();
//    }
//
//    @AfterEach
//    public void afterEach() {
//        String sessionId = getSessionId();
//
//        Attach.screenshotAs("Last screenshot");
//        Attach.pageSource();
//
//        closeWebDriver();
//        Attach.video(sessionId);
//    }
//}
