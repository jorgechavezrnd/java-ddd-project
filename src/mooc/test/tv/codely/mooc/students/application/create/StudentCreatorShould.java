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

        CreateStudentRequest request = new CreateStudentRequest(
            "some-id",
            "some-name",
            "some-surname",
            "some-email"
        );

        Student student = new Student(
            request.id(),
            request.name(),
            request.surname(),
            request.email()
        );

        creator.create(request);

        verify(repository, atLeastOnce()).save(student);
    }
}
