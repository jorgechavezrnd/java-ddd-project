package tv.codely.mooc.students.application.create;

import tv.codely.mooc.students.domain.*;
import tv.codely.shared.domain.Service;

@Service
public final class StudentCreator {
    private final StudentRepository repository;

    public StudentCreator(StudentRepository repository) {
        this.repository = repository;
    }

    public void create(CreateStudentRequest request) {
        Student student = new Student(
            new StudentId(request.id()),
            new StudentName(request.name()),
            new StudentSurname(request.surname()),
            new StudentEmail(request.email())
        );

        repository.save(student);
    }
}
