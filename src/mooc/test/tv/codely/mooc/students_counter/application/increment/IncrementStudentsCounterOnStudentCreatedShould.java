package tv.codely.mooc.students_counter.application.increment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.students.domain.StudentCreatedDomainEvent;
import tv.codely.mooc.students.domain.StudentCreatedDomainEventMother;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students.domain.StudentIdMother;
import tv.codely.mooc.students_counter.StudentsCounterModuleUnitTestCase;
import tv.codely.mooc.students_counter.domain.StudentsCounter;
import tv.codely.mooc.students_counter.domain.StudentsCounterMother;

final class IncrementStudentsCounterOnStudentCreatedShould extends StudentsCounterModuleUnitTestCase {
    IncrementStudentsCounterOnStudentCreated subscriber;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        subscriber = new IncrementStudentsCounterOnStudentCreated(
            new StudentsCounterIncrementer(repository, uuidGenerator)
        );
    }

    @Test
    void initialize_a_new_counter() {
        StudentCreatedDomainEvent event = StudentCreatedDomainEventMother.random();

        StudentId studentId = StudentIdMother.create(event.aggregateId());
        StudentsCounter newCounter = StudentsCounterMother.withOne(studentId);

        shouldSearch();
        shouldGenerateUuid(newCounter.id().value());

        subscriber.on(event);

        shouldHaveSaved(newCounter);
    }

    @Test
    void increment_an_existing_counter() {
        StudentCreatedDomainEvent event = StudentCreatedDomainEventMother.random();

        StudentId       studentId          = StudentIdMother.create(event.aggregateId());
        StudentsCounter existingCounter    = StudentsCounterMother.random();
        StudentsCounter incrementedCounter = StudentsCounterMother.incrementing(existingCounter, studentId);

        shouldSearch(existingCounter);

        subscriber.on(event);

        shouldHaveSaved(incrementedCounter);
    }

    @Test
    void not_increment_an_already_incremented_student() {
        StudentCreatedDomainEvent event = StudentCreatedDomainEventMother.random();

        StudentId studentId = StudentIdMother.create(event.aggregateId());
        StudentsCounter existingCounter = StudentsCounterMother.withOne(studentId);

        shouldSearch(existingCounter);

        subscriber.on(event);
    }
}
