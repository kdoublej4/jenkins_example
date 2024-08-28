package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    @Tag("one_property")
    public void simplePropertyTest() {
        String browserName = System.getProperty("browser", "mozilla");
        String browserVersion = System.getProperty("browser_version", "100.0");

        System.out.println(browserName);
        System.out.println(browserVersion);

        // gradle clean one_property_test -Dbrowser=safari -Dbrowser_version=99.0
    }
}
