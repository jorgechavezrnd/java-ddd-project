package tv.codely.mooc.students_counter.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.students_counter.StudentsCounterModuleInfrastructureTestCase;
import tv.codely.mooc.students_counter.domain.StudentsCounter;
import tv.codely.mooc.students_counter.domain.StudentsCounterMother;

import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@Transactional
class MySqlStudentsCounterRepositoryShould extends StudentsCounterModuleInfrastructureTestCase {
    @Test
    void return_an_existing_students_counter() {
        StudentsCounter counter = StudentsCounterMother.random();

        repository.save(counter);

        assertEquals(Optional.of(counter), repository.search());
    }
}
