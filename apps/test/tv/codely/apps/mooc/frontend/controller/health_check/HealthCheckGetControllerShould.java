package tv.codely.apps.mooc.frontend.controller.health_check;

import org.junit.jupiter.api.Test;
import tv.codely.apps.mooc.frontend.controller.RequestTestCase;

final class HealthCheckGetControllerShould extends RequestTestCase {
    @Test
    void check_the_app_is_working_ok() throws Exception {
        assertResponse("/health-check", 200, "{'status': 'ok', 'application': 'mooc_frontend'}");
    }
}
