package tv.codely.app.mooc.controller.greeter;

import org.junit.jupiter.api.Test;
import tv.codely.app.mooc.controller.RequestTestCase;

final class GreeterGetControllerShould extends RequestTestCase {
    @Test
    void check_greeter_is_working_ok() throws Exception {
        String name = "Jorge";
        String expectedResponse = String.format("{'greet': 'Hi %s'}", name);
        assertResponse(String.format("/greets/%s", name), 200, expectedResponse);
    }
}
