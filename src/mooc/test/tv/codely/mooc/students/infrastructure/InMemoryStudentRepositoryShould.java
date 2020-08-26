package tv.codely.mooc.students.infrastructure;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.students.domain.*;

import java.util.Optional;

final class InMemoryStudentRepositoryShould {
    @Test
    void save_a_student() {
        InMemoryStudentRepository repository = new InMemoryStudentRepository();
        Student student = new Student(
            new StudentId("1aab45ba-3c7a-4344-8936-78466eca77fa"),
            new StudentName("name"),
            new StudentSurname("surname"),
            new StudentEmail("email")
        );

        repository.save(student);
    }

    @Test
    void return_an_existing_student() {
        InMemoryStudentRepository repository = new InMemoryStudentRepository();
        Student student = new Student(
            new StudentId("1aab45ba-3c7a-4344-8936-78466eca77fa"),
            new StudentName("name"),
            new StudentSurname("surname"),
            new StudentEmail("email")
        );

        repository.save(student);

        Assert.assertEquals(Optional.of(student), repository.search(student.id()));
    }

    @Test
    void not_return_a_non_existing_student() {
        InMemoryStudentRepository repository = new InMemoryStudentRepository();

        Assert.assertFalse(repository.search(new StudentId("6a778254-0708-4011-9ede-5d9c78fd1d15")).isPresent());
    }
}
