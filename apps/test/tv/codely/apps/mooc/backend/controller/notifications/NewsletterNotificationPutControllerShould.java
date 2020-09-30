package tv.codely.apps.mooc.backend.controller.notifications;

import org.junit.jupiter.api.Test;
import tv.codely.apps.mooc.MoocApplicationTestCase;

final class NewsletterNotificationPutControllerShould extends MoocApplicationTestCase {
    @Test
    void dispatch_send_new_courses_newsletter_command() throws Exception {
        assertRequest(
            "PUT",
            "/newsletter/6eebbe60-50e7-400a-810c-3e0af0943ee6",
            201
        );
    }
}
