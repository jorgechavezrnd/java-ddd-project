package tv.codely.mooc.students.infrastructure;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.students.domain.Student;

final class InMemoryStudentRepositoryShould {
    @Test
    void save_a_course() {
        InMemoryStudentRepository repository = new InMemoryStudentRepository();

        repository.save(new Student("some-id", "some-name", "some-email"));
    }
}
