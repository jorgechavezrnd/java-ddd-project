package tv.codely.app.mooc.controller.students;

import org.junit.jupiter.api.Test;
import tv.codely.app.mooc.controller.RequestTestCase;

public final class StudentsPutControllerShould extends RequestTestCase {
    @Test
    void create_a_valid_non_existing_student() throws Exception {
        assertRequestWithBody(
            "PUT",
            "/students/bdf3a366-ea3d-471a-93c4-9139cac48baa",
            "{\"name\": \"Jorge\", \"email\": \"jorge@gmail.com\"}",
            201
        );
    }
}
