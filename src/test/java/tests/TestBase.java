package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;

import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class TestBase {
    RegistrationPage formPage = new RegistrationPage();
    Faker faker = new Faker(new Locale("it"));
    @BeforeEach
    public void allureListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void addAttachments() {
        Attach.screenshotAs("Last Screenshot");
        Attach.pageSource();                    // <============================
        Attach.browserConsoleLogs();
    }

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
        Configuration.holdBrowserOpen = false;

//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("selenoid:options", Map.<String, Objects>of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));
//        Configuration.browserCapabilities = capabilities;
    }
}
