package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    @Tag("one_property")
    public void simplePropertyTest() {
        String browserName = System.getProperty("browser", "mozilla");

        System.out.println(browserName);
    }
}
