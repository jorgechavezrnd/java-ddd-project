package tv.codely.mooc.students.application.create;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.students.domain.*;

import static org.mockito.Mockito.*;

final class StudentCreatorShould {
    @Test
    void save_a_valid_student() {
        StudentRepository repository = mock(StudentRepository.class);
        StudentCreator    creator    = new StudentCreator(repository);

        CreateStudentRequest request = new CreateStudentRequest(
            "1aab45ba-3c7a-4344-8936-78466eca77fa",
            "name",
            "surname",
            "email"
        );

        Student student = new Student(
            new StudentId(request.id()),
            new StudentName(request.name()),
            new StudentSurname(request.surname()),
            new StudentEmail(request.email())
        );

        creator.create(request);

        verify(repository, atLeastOnce()).save(student);
    }
}
