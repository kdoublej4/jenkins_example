import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Simple")
public class PositiveTests extends BaseTest {

    @Test
    void test1() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        assertTrue(true);
    }

    @Test
    void test2() {
        assertTrue(true);
    }

    @Test
    void test3() {
        assertTrue(true);
    }

    @Test
    void test4() {
        assertTrue(true);
    }

    @Test
    void test5() {
        assertTrue(true);
    }
}
