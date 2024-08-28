import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("negative")
public class NegativeTests {

    @Test
    void test1() {
        assertTrue(false);
    }

    @Test
    void test2() {
        assertTrue(false);
    }

    @Test
    void test3() {
        assertTrue(false);
    }

    @Test
    void test4() {
        assertTrue(false);
    }

    @Test
    void test5() {
        assertTrue(false);
    }

}
