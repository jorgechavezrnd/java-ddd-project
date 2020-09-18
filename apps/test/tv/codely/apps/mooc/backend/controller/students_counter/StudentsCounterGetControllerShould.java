package tv.codely.apps.mooc.backend.controller.students_counter;

import org.junit.jupiter.api.Test;
import tv.codely.apps.mooc.backend.controller.ApplicationTestCase;
import tv.codely.mooc.students.domain.StudentCreatedDomainEvent;

public final class StudentsCounterGetControllerShould extends ApplicationTestCase {
    @Test
    void get_the_counter_with_one_student() throws Exception {
        givenISendEventsToTheBus(
            new StudentCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "Pepe", "Anderson", "pepe@gmail.com")
        );

        assertResponse("/students-counter", 200, "{'total': 1}");
    }

    @Test
    void get_the_counter_with_more_than_one_student() throws Exception {
        givenISendEventsToTheBus(
            new StudentCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "Pepe", "Anderson", "pepe@gmail.com"),
            new StudentCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "Samuel", "Zurita", "samuel@gmail.com"),
            new StudentCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "Kevin", "Aparicio", "kevin@gmail.com")
        );

        assertResponse("/students-counter", 200, "{'total': 3}");
    }

    @Test
    void get_the_counter_with_more_than_one_student_having_duplicated_events() throws Exception {
        givenISendEventsToTheBus(
            new StudentCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "Pepe", "Anderson", "pepe@gmail.com"),
            new StudentCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "Pepe", "Anderson", "pepe@gmail.com"),
            new StudentCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "Pepe", "Anderson", "pepe@gmail.com"),
            new StudentCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "Samuel", "Zurita", "samuel@gmail.com"),
            new StudentCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "Samuel", "Zurita", "samuel@gmail.com"),
            new StudentCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "Samuel", "Zurita", "samuel@gmail.com"),
            new StudentCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "Samuel", "Zurita", "samuel@gmail.com"),
            new StudentCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "Kevin", "Aparicio", "kevin@gmail.com"),
            new StudentCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "Kevin", "Aparicio", "kevin@gmail.com")
        );

        assertResponse("/students-counter", 200, "{'total': 3}");
    }
}
