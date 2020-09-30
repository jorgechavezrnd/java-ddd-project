package tv.codely.apps.backoffice.frontend.controller.health_check;

import org.junit.jupiter.api.Test;
import tv.codely.apps.backoffice.BackofficeApplicationTestCase;

final class HealthCheckGetControllerShould extends BackofficeApplicationTestCase {
    @Test
    void check_the_app_is_working_ok() throws Exception {
        assertResponse("/health-check", 200, "{'application':'backoffice_frontend','status':'ok'}");
    }
}
