package tv.codely.apps.mooc.backend.controller.videos;

import org.junit.jupiter.api.Test;
import tv.codely.apps.mooc.backend.controller.ApplicationTestCase;

public final class VideosPutControllerShould extends ApplicationTestCase {
    @Test
    void create_a_valid_non_existing_video() throws Exception {
        assertRequestWithBody(
            "PUT",
            "/courses/3642f700-868a-4778-9317-a2d542d01785",
            "{\"name\": \"The best course\", \"duration\": \"5 hours\"}",
            201
        );

        assertRequestWithBody(
            "PUT",
            "/videos/1aab45ba-3c7a-4344-8936-78466eca77fa",
            "{\"type\": \"Live coding\", \"title\": \"Implementing PUT controller for videos\", \"url\": \"http://codely.tv/videos/videoscontroller\", \"courseId\": \"3642f700-868a-4778-9317-a2d542d01785\"}",
            201
        );
    }
}
