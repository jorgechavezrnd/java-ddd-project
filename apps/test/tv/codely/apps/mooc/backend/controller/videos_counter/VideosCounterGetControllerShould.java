package tv.codely.apps.mooc.backend.controller.videos_counter;

import org.junit.jupiter.api.Test;
import tv.codely.apps.mooc.backend.controller.ApplicationTestCase;
import tv.codely.shared.domain.video.VideoCreatedDomainEvent;

public final class VideosCounterGetControllerShould extends ApplicationTestCase {
    @Test
    void get_one_counter_with_one_video() throws Exception {
        createCourse("3642f700-868a-4778-9317-a2d542d01785", "The best course", "5 hours");

        givenISendEventsToTheBus(
            new VideoCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "Live Coding", "Creating Videos Put Controller", "http://codelytv/videos/videoscontroller", "3642f700-868a-4778-9317-a2d542d01785")
        );

        assertResponse(
            "/videos-counter/3642f700-868a-4778-9317-a2d542d01785",
            200,
            "{'total': 1}"
        );
    }

    @Test
    void get_one_counter_with_more_than_one_video() throws Exception {
        createCourse("3642f700-868a-4778-9317-a2d542d01785", "The best course", "5 hours");

        givenISendEventsToTheBus(
            new VideoCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "Live Coding", "Creating Videos Put Controller", "http://codelytv/videos/videoscontroller", "3642f700-868a-4778-9317-a2d542d01785"),
            new VideoCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "Refactoring", "Refactoring controller for courses", "http://codelytv/videos/refactoringcourses", "3642f700-868a-4778-9317-a2d542d01785"),
            new VideoCreatedDomainEvent("fbca3dae-5370-4c5e-b834-8ee026bafede", "Theory", "DDD theory", "http://codelytv/videos/dddtheory", "3642f700-868a-4778-9317-a2d542d01785")
        );

        assertResponse(
            "/videos-counter/3642f700-868a-4778-9317-a2d542d01785",
            200,
            "{'total': 3}"
        );
    }

    @Test
    void get_one_counter_with_more_than_one_video_having_duplicated_events() throws Exception {
        createCourse("3642f700-868a-4778-9317-a2d542d01785", "The best course", "5 hours");

        givenISendEventsToTheBus(
            new VideoCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "Live Coding", "Creating Videos Put Controller", "http://codelytv/videos/videoscontroller", "3642f700-868a-4778-9317-a2d542d01785"),
            new VideoCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "Live Coding", "Creating Videos Put Controller", "http://codelytv/videos/videoscontroller", "3642f700-868a-4778-9317-a2d542d01785"),
            new VideoCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "Live Coding", "Creating Videos Put Controller", "http://codelytv/videos/videoscontroller", "3642f700-868a-4778-9317-a2d542d01785"),
            new VideoCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "Refactoring", "Refactoring controller for courses", "http://codelytv/videos/refactoringcourses", "3642f700-868a-4778-9317-a2d542d01785"),
            new VideoCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "Refactoring", "Refactoring controller for courses", "http://codelytv/videos/refactoringcourses", "3642f700-868a-4778-9317-a2d542d01785"),
            new VideoCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "Refactoring", "Refactoring controller for courses", "http://codelytv/videos/refactoringcourses", "3642f700-868a-4778-9317-a2d542d01785"),
            new VideoCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "Refactoring", "Refactoring controller for courses", "http://codelytv/videos/refactoringcourses", "3642f700-868a-4778-9317-a2d542d01785"),
            new VideoCreatedDomainEvent("fbca3dae-5370-4c5e-b834-8ee026bafede", "Theory", "DDD theory", "http://codelytv/videos/dddtheory", "3642f700-868a-4778-9317-a2d542d01785"),
            new VideoCreatedDomainEvent("fbca3dae-5370-4c5e-b834-8ee026bafede", "Theory", "DDD theory", "http://codelytv/videos/dddtheory", "3642f700-868a-4778-9317-a2d542d01785")
        );

        assertResponse(
            "/videos-counter/3642f700-868a-4778-9317-a2d542d01785",
            200,
            "{'total': 3}"
        );
    }

    @Test
    void get_one_counter_with_more_than_one_course_and_more_than_one_video() throws Exception {
        createCourse("3642f700-868a-4778-9317-a2d542d01785", "The best course", "5 hours");
        createCourse("e6f719de-2698-45a7-aad6-eb23019a6e56", "DDD en Java", "10 hours");

        givenISendEventsToTheBus(
            new VideoCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "Live Coding", "Creating Videos Put Controller", "http://codelytv/videos/videoscontroller", "3642f700-868a-4778-9317-a2d542d01785"),
            new VideoCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "Refactoring", "Refactoring controller for courses", "http://codelytv/videos/refactoringcourses", "3642f700-868a-4778-9317-a2d542d01785"),
            new VideoCreatedDomainEvent("fbca3dae-5370-4c5e-b834-8ee026bafede", "Theory", "DDD theory", "http://codelytv/videos/dddtheory", "e6f719de-2698-45a7-aad6-eb23019a6e56")
        );

        assertResponse(
            "/videos-counter/3642f700-868a-4778-9317-a2d542d01785",
            200,
            "{'total': 2}"
        );
    }

    @Test
    void get_one_counter_with_more_than_one_course_and_more_than_one_video_having_duplicated_events() throws Exception {
        createCourse("3642f700-868a-4778-9317-a2d542d01785", "The best course", "5 hours");
        createCourse("e6f719de-2698-45a7-aad6-eb23019a6e56", "DDD en Java", "10 hours");

        givenISendEventsToTheBus(
            new VideoCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "Live Coding", "Creating Videos Put Controller", "http://codelytv/videos/videoscontroller", "3642f700-868a-4778-9317-a2d542d01785"),
            new VideoCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "Live Coding", "Creating Videos Put Controller", "http://codelytv/videos/videoscontroller", "3642f700-868a-4778-9317-a2d542d01785"),
            new VideoCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "Live Coding", "Creating Videos Put Controller", "http://codelytv/videos/videoscontroller", "3642f700-868a-4778-9317-a2d542d01785"),
            new VideoCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "Refactoring", "Refactoring controller for courses", "http://codelytv/videos/refactoringcourses", "e6f719de-2698-45a7-aad6-eb23019a6e56"),
            new VideoCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "Refactoring", "Refactoring controller for courses", "http://codelytv/videos/refactoringcourses", "e6f719de-2698-45a7-aad6-eb23019a6e56"),
            new VideoCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "Refactoring", "Refactoring controller for courses", "http://codelytv/videos/refactoringcourses", "e6f719de-2698-45a7-aad6-eb23019a6e56"),
            new VideoCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "Refactoring", "Refactoring controller for courses", "http://codelytv/videos/refactoringcourses", "e6f719de-2698-45a7-aad6-eb23019a6e56"),
            new VideoCreatedDomainEvent("fbca3dae-5370-4c5e-b834-8ee026bafede", "Theory", "DDD theory", "http://codelytv/videos/dddtheory", "e6f719de-2698-45a7-aad6-eb23019a6e56"),
            new VideoCreatedDomainEvent("fbca3dae-5370-4c5e-b834-8ee026bafede", "Theory", "DDD theory", "http://codelytv/videos/dddtheory", "e6f719de-2698-45a7-aad6-eb23019a6e56"),
            new VideoCreatedDomainEvent("94471c29-feee-40a2-b01b-0acaffa93950", "Practice", "Implementing module for videos", "http://codelytv/videos/videosmodule", "e6f719de-2698-45a7-aad6-eb23019a6e56"),
            new VideoCreatedDomainEvent("94471c29-feee-40a2-b01b-0acaffa93950", "Practice", "Implementing module for videos", "http://codelytv/videos/videosmodule", "e6f719de-2698-45a7-aad6-eb23019a6e56")
        );

        assertResponse(
            "/videos-counter/e6f719de-2698-45a7-aad6-eb23019a6e56",
            200,
            "{'total': 3}"
        );
    }

    private void createCourse(String id, String name, String duration) throws Exception {
        assertRequestWithBody(
            "PUT",
            String.format("/courses/%s", id),
            String.format("{\"name\": \"%s\", \"duration\": \"%s\"}", name, duration),
            201
        );
    }
}
