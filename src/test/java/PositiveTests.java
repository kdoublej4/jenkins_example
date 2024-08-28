import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("simple") // <=======
public class PositiveTests extends TestBase {

    @Test
    void test1() {
        assertTrue(true);
    }
    @Tag("simple") // <========
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

