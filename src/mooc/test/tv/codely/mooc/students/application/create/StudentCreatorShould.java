package tv.codely.mooc.students.application.create;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentRepository;

import static org.mockito.Mockito.*;

final class StudentCreatorShould {
    @Test
    void save_a_valid_student() {
        StudentRepository repository = mock(StudentRepository.class);
        StudentCreator    creator    = new StudentCreator(repository);

        Student student = new Student("some-id", "some-name", "some-surname", "some-email");

        creator.create(student.id(), student.name(), student.surname(), student.email());

        verify(repository, atLeastOnce()).save(student);
    }
}
