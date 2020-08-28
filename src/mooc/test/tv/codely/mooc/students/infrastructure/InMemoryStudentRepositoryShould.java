package tv.codely.mooc.students.infrastructure;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.students.StudentsModuleInfrastructureTestCase;
import tv.codely.mooc.students.domain.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

final class InMemoryStudentRepositoryShould extends StudentsModuleInfrastructureTestCase {
    @Test
    void save_a_student() {
        Student student = StudentMother.random();

        repository.save(student);
    }

    @Test
    void return_an_existing_student() {
        Student student = StudentMother.random();

        repository.save(student);

        assertEquals(Optional.of(student), repository.search(student.id()));
    }

    @Test
    void not_return_a_non_existing_student() {
        assertFalse(repository.search(StudentIdMother.random()).isPresent());
    }
}
