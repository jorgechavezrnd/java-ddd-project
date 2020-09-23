package tv.codely.mooc.students.infrastructure;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.students.StudentsModuleInfrastructureTestCase;
import tv.codely.mooc.students.domain.*;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Transactional
class MySqlStudentRepositoryShould extends StudentsModuleInfrastructureTestCase {
    @Test
    void save_a_student() {
        Student student = StudentMother.random();

        mySqlStudentRepository.save(student);
    }

    @Test
    void return_an_existing_student() {
        Student student = StudentMother.random();

        mySqlStudentRepository.save(student);

        assertEquals(Optional.of(student), mySqlStudentRepository.search(student.id()));
    }

    @Test
    void not_return_a_non_existing_student() {
        assertFalse(mySqlStudentRepository.search(StudentIdMother.random()).isPresent());
    }
}
