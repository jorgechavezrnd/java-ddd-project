package tv.codely.apps.mooc.backend.controller.students;

import org.junit.jupiter.api.Test;
import tv.codely.apps.mooc.backend.controller.ApplicationTestCase;

public final class StudentsPutControllerShould extends ApplicationTestCase {
    @Test
    void create_a_valid_non_existing_course() throws Exception {
        assertRequestWithBody(
            "PUT",
            "/students/bdf3a366-ea3d-471a-93c4-9139cac48baa",
            "{\"name\": \"Jorge\", \"surname\": \"Chavez\", \"email\": \"jorge@gmail.com\"}",
            201
        );
    }
}
