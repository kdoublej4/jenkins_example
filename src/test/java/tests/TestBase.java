package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;

import java.util.Locale;

public class TestBase {
    RegistrationPage formPage = new RegistrationPage();
    Faker faker = new Faker(new Locale("it"));

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
