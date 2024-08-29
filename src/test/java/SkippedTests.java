import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("skipped")
@Tag("example")
public class SkippedTests {

    @Test
    @Disabled
    void test1() {
        assertTrue(true);
    }

    @Test
    @Disabled
    void test2() {
        assertTrue(true);
    }
}
