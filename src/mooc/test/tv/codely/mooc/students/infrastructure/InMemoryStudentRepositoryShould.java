package tv.codely.mooc.students.infrastructure;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.students.domain.Student;

import java.util.Optional;

final class InMemoryStudentRepositoryShould {
    @Test
    void save_a_student() {
        InMemoryStudentRepository repository = new InMemoryStudentRepository();

        repository.save(new Student("some-id", "some-name", "some-surname", "some-email"));
    }

    @Test
    void return_an_existing_student() {
        InMemoryStudentRepository repository = new InMemoryStudentRepository();

        Student student = new Student("some-id", "some-name", "some-surname", "some-email");

        repository.save(student);

        Assert.assertEquals(Optional.of(student), repository.search(student.id()));
    }

    @Test
    void not_return_a_non_existing_student() {
        InMemoryStudentRepository repository = new InMemoryStudentRepository();

        Assert.assertFalse(repository.search("non-existing-id").isPresent());
    }
}
