package tv.codely.mooc.students_counter.application.find;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.students_counter.StudentsCounterModuleUnitTestCase;
import tv.codely.mooc.students_counter.domain.StudentsCounter;
import tv.codely.mooc.students_counter.domain.StudentsCounterMother;
import tv.codely.mooc.students_counter.domain.StudentsCounterNotInitialized;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class FindStudentsCounterQueryHandlerShould extends StudentsCounterModuleUnitTestCase {
    FindStudentsCounterQueryHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        handler = new FindStudentsCounterQueryHandler(new StudentsCounterFinder(repository));
    }

    @Test
    void find_an_existing_students_counter() {
        StudentsCounter          counter  = StudentsCounterMother.random();
        FindStudentsCounterQuery query = new FindStudentsCounterQuery();
        StudentsCounterResponse  response = StudentsCounterResponseMother.create(counter.total().value());

        shouldSearch(counter);

        assertEquals(response, handler.handle(query));
    }

    @Test
    void throw_an_exception_when_students_counter_does_not_exists() {
        FindStudentsCounterQuery query = new FindStudentsCounterQuery();

        shouldSearch();

        assertThrows(StudentsCounterNotInitialized.class, () -> handler.handle(query));
    }
}
